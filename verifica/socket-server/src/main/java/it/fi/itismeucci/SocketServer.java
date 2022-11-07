package it.fi.itismeucci;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.net.*;

public class SocketServer {

    private Messaggio messaggio = new Messaggio();

    public Messaggio getMessaggio() {
        return this.messaggio;
    }

    public void setMessaggio(Messaggio messaggio) {
        this.messaggio = messaggio;
    }

    public Socket avvia() throws IOException {
        ServerSocket server = new ServerSocket(34567);

        for (;;) {
            Socket client = server.accept();
            XmlMapper mapper = new XmlMapper();
            XmlMapper xmlMapper = new XmlMapper();
            try {
                String xml = xmlMapper.writeValueAsString(messaggio);
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                DataOutputStream out = new DataOutputStream(client.getOutputStream());
                Messaggio messaggio = xmlMapper.readValue(xml, Messaggio.class);
                String recv = in.readLine();
                if (recv.equals("fine")) {
                    out.writeBytes("@" + "\n");
                } else {
                    out.writeBytes(xml + '\n');
                }
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

        }
    }
}
