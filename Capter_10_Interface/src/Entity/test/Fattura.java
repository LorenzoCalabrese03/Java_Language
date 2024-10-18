package Entity.test;

public class Fattura implements Pagamento {

    private int numArticoli;
    private double prezzoUnita;

    /**
     * Costruttore di default per creare una nuova fattura.
     */
    public Fattura() {
        this.numArticoli = 0;
        this.prezzoUnita = 0.0;
    }

    /**
     * Costruttore per inizializzare una fattura con il numero di articoli e il prezzo unitario.
     * 
     * @param numArticoli Il numero di articoli nella fattura.
     * @param prezzoUnita Il prezzo per ogni articolo.
     */
    public Fattura(int numArticoli, double prezzoUnita) {
        this.numArticoli = numArticoli;
        this.prezzoUnita = prezzoUnita;
    }

    /**
     * Calcola l'importo totale della fattura.
     * 
     * @return L'importo totale calcolato come numArticoli * prezzoUnita.
     */
    @Override
    public double calcoloImporto() {
        return prezzoUnita * numArticoli;
    }

    /**
     * Restituisce il numero di articoli nella fattura.
     * 
     * @return Il numero di articoli.
     */
    public int getNumArticoli() {
        return numArticoli;
    }

    /**
     * Imposta il numero di articoli nella fattura.
     * 
     * @param numArticoli Il numero di articoli.
     */
    public void setNumArticoli(int numArticoli) {
        this.numArticoli = numArticoli;
    }

    /**
     * Restituisce il prezzo per unità della fattura.
     * 
     * @return Il prezzo unitario.
     */
    public double getPrezzoUnita() {
        return prezzoUnita;
    }

    /**
     * Imposta il prezzo per unità della fattura.
     * 
     * @param prezzoUnita Il prezzo unitario.
     */
    public void setPrezzoUnita(double prezzoUnita) {
        this.prezzoUnita = prezzoUnita;
    }

    /**
     * Restituisce una rappresentazione della fattura come stringa.
     * 
     * @return Una stringa che rappresenta la fattura.
     */
    @Override
    public String toString() {
        return String.format(
            "Numero Articoli: %d\nPrezzo unitario: %.2f\nImporto totale: %.2f",
            numArticoli, prezzoUnita, calcoloImporto()
        );
    }
}
