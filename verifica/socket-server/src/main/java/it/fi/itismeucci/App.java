package it.fi.itismeucci;

import java.io.IOException;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws IOException {
       
        Biglietto b1 = new Biglietto();
        b1.setId(1);
        b1.setNumBiglietto("palco-1a");
        Biglietto b2 = new Biglietto();
        b2.setId(2);
        b2.setNumBiglietto("palco-2a");
        Biglietto b3 = new Biglietto();
        b3.setId(3);
        b3.setNumBiglietto("palco-3a");
        Biglietto b4 = new Biglietto();
        b4.setId(4);
        b4.setNumBiglietto("palco-4a");
        Biglietto b5 = new Biglietto();
        b5.setId(5);
        b5.setNumBiglietto("palco-5a");
        ArrayList<Biglietto> bs = new ArrayList<Biglietto>();
        bs.add(b1);
        bs.add(b2);
        bs.add(b3);
        bs.add(b4);
        bs.add(b5);
        Messaggio messaggio = new Messaggio();
        messaggio.setBigliettos(bs);
        SocketServer server = new SocketServer();
        server.setMessaggio(messaggio);
        server.avvia();
    }
}
