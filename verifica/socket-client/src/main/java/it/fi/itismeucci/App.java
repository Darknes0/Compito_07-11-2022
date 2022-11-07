package it.fi.itismeucci;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        SocketClient client = new SocketClient();
        Messaggio messaggio = new Messaggio();
        client.setMessaggio(messaggio);
        client.connect();
        client.send();
       
    }
}
