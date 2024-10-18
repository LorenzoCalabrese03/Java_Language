package Entity.test;

public class prodottiElettronici extends Prodotto {
    private int garanzia;

    /**
     * Costruttore per creare un nuovo prodotto elettronico.
     * 
     * @param codice Il codice del prodotto.
     * @param prezzoIniziale Il prezzo iniziale del prodotto.
     * @param garanzia La durata della garanzia in mesi (compresa tra 2 e 24).
     */
    public prodottiElettronici(String codice, double prezzoIniziale, int garanzia) {
        super(codice, prezzoIniziale);
        
        // Imposta la garanzia garantendo che sia tra 2 e 24 mesi
        this.garanzia = Math.max(2, Math.min(garanzia, 24));
    }

    /**
     * Restituisce la durata della garanzia del prodotto.
     * 
     * @return La durata della garanzia in mesi.
     */
    public int getGaranzia() {
        return garanzia;
    }

    /**
     * Imposta la durata della garanzia del prodotto.
     * 
     * @param garanzia La durata della garanzia in mesi (compresa tra 2 e 24).
     */
    public void setGaranzia(int garanzia) {
        // Imposta la garanzia solo se il valore è tra 2 e 24 mesi
        this.garanzia = Math.max(2, Math.min(garanzia, 24));
    }

    /**
     * Calcola il costo del prodotto elettronico.
     * Se la garanzia è di 12 mesi o più, il prezzo aumenta del 10%.
     * 
     * @return Il costo calcolato del prodotto.
     */
    @Override
    public double calcolaCosto() {
        double costo = super.getPrezzoIniziale();
        
        // Aumenta il costo del 10% se la garanzia è di 12 mesi o superiore
        if (garanzia >= 12) {
            costo += super.getPrezzoIniziale() * 0.1;
        }
        return costo;
    }

    /**
     * Restituisce una rappresentazione del prodotto elettronico come stringa.
     * 
     * @return Una stringa che rappresenta il prodotto elettronico.
     */
    @Override
    public String toString() {
        return String.format(
            "Prodotto Elettronico:\nCodice: %s\nPrezzo Iniziale: %.2f\nCosto Calcolato: %.2f\nGaranzia: %d mesi",
            getCodice(), getPrezzoIniziale(), calcolaCosto(), garanzia
        );
    }
}
