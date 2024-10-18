package Entity.test;

public abstract class Prodotto implements Pagamento {
    private final String codice;
    protected double prezzoIniziale;

    /**
     * Costruttore per la classe Prodotto.
     * 
     * @param codice         Il codice del prodotto (non può essere nullo o vuoto).
     * @param prezzoIniziale Il prezzo iniziale del prodotto (non può essere negativo).
     */
    public Prodotto(String codice, double prezzoIniziale) {
        // Validazione del codice
        if (codice == null || codice.isEmpty()) {
            throw new IllegalArgumentException("Il codice del prodotto non può essere nullo o vuoto.");
        }
        this.codice = codice;

        // Inizializzazione del prezzo iniziale
        if (prezzoIniziale < 0) {
            throw new IllegalArgumentException("Il prezzo iniziale non può essere negativo.");
        }
        this.prezzoIniziale = prezzoIniziale;
    }

    /**
     * Restituisce il codice del prodotto.
     * 
     * @return Il codice del prodotto.
     */
    public String getCodice() {
        return codice;
    }

    /**
     * Restituisce il prezzo iniziale del prodotto.
     * 
     * @return Il prezzo iniziale del prodotto.
     */
    public double getPrezzoIniziale() {
        return prezzoIniziale;
    }

    /**
     * Implementazione del metodo dell'interfaccia Pagamento.
     * Calcola l'importo totale per il prodotto.
     * 
     * @return Il costo totale del prodotto.
     */
    @Override
    public double calcoloImporto() {
        return calcolaCosto();
    }

    /**
     * Metodo astratto per calcolare il costo del prodotto.
     * Deve essere implementato dalle classi derivate.
     * 
     * @return Il costo del prodotto.
     */
    public abstract double calcolaCosto();

    /**
     * Metodo astratto per ottenere la rappresentazione in stringa del prodotto.
     * Deve essere implementato dalle classi derivate.
     * 
     * @return La rappresentazione del prodotto come stringa.
     */
    @Override
    public abstract String toString();
}
