package it.fi.itismeucci;



public class Biglietto {
    private int Id;
    private String NumBiglietto;

    public Biglietto() {
    }

    public Biglietto(int Id, String NumBiglietto) {
        this.Id = Id;
        this.NumBiglietto = NumBiglietto;
    }

    public int getId() {
        return this.Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNumBiglietto() {
        return this.NumBiglietto;
    }

    public void setNumBiglietto(String NumBiglietto) {
        this.NumBiglietto = NumBiglietto;
    }

}
