package prodotto;

public abstract class Prodotti {
    private final String codice;
    protected double prezzoIniziale;

    // Costruttore
    public Prodotti(String codice, double prezzoIniziale) {
        // Validazione e inizializzazione del codice
        if (codice == null || codice.isEmpty()) {
            this.codice = "$"; // codice di errore nel caso il codice non ci sia
        } else {
            this.codice = codice; // Inizializzazione del codice
        }
        
        // Inizializzazione del prezzo iniziale
        if (prezzoIniziale < 0) {
            this.prezzoIniziale = 0;
        } else {
            this.prezzoIniziale = prezzoIniziale;
        }
    }

    public String getCodice() {
        return codice;
    }

    public double getPrezzoIniziale() {
        return prezzoIniziale;
    }

    public abstract double calcolaCosto();
	public abstract void Stampa();
}
