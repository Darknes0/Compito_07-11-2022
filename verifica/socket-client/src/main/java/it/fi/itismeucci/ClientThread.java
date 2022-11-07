package it.fi.itismeucci;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;
public class ClientThread extends Thread{
    private DataOutputStream out;
    private Scanner keyboard = new Scanner(System.in);
    private String userString;
    public ClientThread(DataOutputStream out){
        this.out = out;
    }

    public void run() {
        for(;;){
            try {
                out.writeBytes(userString + '\n');
            }catch(IOException e){}
            System.out.print("Inserisci la stringa da trasmettere al server" + '\n');  
            this.userString = this.keyboard.next();
            try {
                out.writeBytes(userString + '\n');
            }catch(IOException e){}
        }

    }
}
