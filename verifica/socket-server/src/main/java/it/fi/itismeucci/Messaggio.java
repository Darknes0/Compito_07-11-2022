package it.fi.itismeucci;

import java.util.ArrayList;

public class Messaggio {

    private ArrayList<Biglietto> bigliettos;

    public Messaggio() {
    }

    public Messaggio(ArrayList<Biglietto> bigliettos) {
        this.bigliettos = bigliettos;
    }

    public ArrayList<Biglietto> getBigliettos() {
        return this.bigliettos;
    }

    public void setBigliettos(ArrayList<Biglietto> bigliettos) {
        this.bigliettos = bigliettos;
    }

    public Messaggio bigliettos(ArrayList<Biglietto> bigliettos) {
        setBigliettos(bigliettos);
        return this;
    }

}
