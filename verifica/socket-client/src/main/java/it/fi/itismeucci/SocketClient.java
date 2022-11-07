package it.fi.itismeucci;

import java.io.*;
import java.net.*;
import java.util.*;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class SocketClient {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Messaggio messaggio = new Messaggio();
    private String userString = "";
    private String serverString;
    private Scanner keyboard = new Scanner(System.in);

    public Messaggio getMessaggio() {
        return this.messaggio;
    }

    public void setMessaggio(Messaggio messaggio) {
        this.messaggio = messaggio;
    }

    public Socket connect() throws IOException {
        this.socket = new Socket(InetAddress.getLocalHost(), 34567);
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
        
        XmlMapper xmlMapper = new XmlMapper();
        
        for(;;){
            
            try {
                String xml = xmlMapper.writeValueAsString(messaggio);
                out.writeBytes(xml + '\n');
                Messaggio messaggio = xmlMapper.readValue(xml, Messaggio.class);
                ArrayList<Biglietto>  bigliettos = messaggio.getBigliettos();
                for (Biglietto biglietto : bigliettos) {
                    System.out.print( biglietto.getId()+ '\n');
                    System.out.println( biglietto.getNumBiglietto()+ '\n');
                }
            }catch(IOException e){}
            System.out.print("Digita |fine| se vuoi chiudere" + '\n');  
            this.userString = this.keyboard.next();
            try {
                out.writeBytes(userString + '\n');
            }catch(IOException e){}
        }
       
    }

    public void send() throws IOException {
        for (;;) {
            serverString = in.readLine();
            
            if (this.serverString.equals("@")) {
               
                socket.close();
                c.stop();
                break;
            }
            System.out.print("Risposta dal server: " + '\n' + serverString + '\n');
         
        }
    }
}
