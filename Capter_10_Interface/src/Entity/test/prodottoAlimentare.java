package Entity.test;
/**
 * é la sotto-classe di Prodotto e rappresenta un prodotto alimentare.
 * Offre metodi per calcolare l'importo del prodotto in base alla scadenza.
 * @author Lorenzo Calabrese
 *  */
public class prodottoAlimentare extends Prodotto {
    
    private String principioNutritivo;
    private int tempoConservazione;

    /**
     * Costruttore per creare un nuovo prodotto alimentare.
     * 
     * @param codice Il codice del prodotto.
     * @param prezzoIniziale Il prezzo iniziale del prodotto.
     * @param principioNutritivo Il principio nutritivo del prodotto.
     * @param tempoConservazione Il tempo di conservazione del prodotto (minimo 1).
     */
    public prodottoAlimentare(String codice, double prezzoIniziale, String principioNutritivo, int tempoConservazione) {
        super(codice, prezzoIniziale);
        
        // Validazione e assegnazione del principio nutritivo
        if (principioNutritivo == null || principioNutritivo.isEmpty()) {
            throw new IllegalArgumentException("Il principio nutritivo non può essere nullo o vuoto.");
        }
        this.principioNutritivo = principioNutritivo;
        
        // Validazione e assegnazione del tempo di conservazione
        this.tempoConservazione = Math.max(Requisito.MINTEMPCONSERVA, tempoConservazione);
    }

    /**
     * Restituisce il principio nutritivo del prodotto.
     * 
     * @return Il principio nutritivo.
     */
    public String getPrincipioNutritivo() {
        return principioNutritivo;
    }

    /**
     * Imposta il principio nutritivo del prodotto.
     * 
     * @param principioNutritivo Il nuovo principio nutritivo.
     */
    public void setPrincipioNutritivo(String principioNutritivo) {
        if (principioNutritivo == null || principioNutritivo.isEmpty()) {
            throw new IllegalArgumentException("Il principio nutritivo non può essere nullo o vuoto.");
        }
        this.principioNutritivo = principioNutritivo;
    }

    /**
     * Restituisce il tempo di conservazione del prodotto.
     * 
     * @return Il tempo di conservazione (in giorni o unità rilevanti).
     */
    public int getTempoConservazione() {
        return tempoConservazione;
    }

    /**
     * Imposta il tempo di conservazione del prodotto.
     * 
     * @param tempoConservazione Il nuovo tempo di conservazione (minimo 1).
     */
    public void setTempoConservazione(int tempoConservazione) {
        this.tempoConservazione = Math.max(1, tempoConservazione);
    }

    /**
     * Calcola il costo del prodotto alimentare.
     * Se il tempo di conservazione è di 1, il prezzo viene ridotto della metà.
     * 
     * @return Il costo calcolato del prodotto.
     */
    @Override
    public double calcolaCosto() {
        double costo = super.getPrezzoIniziale();
        
        // Riduzione del costo del prodotto se la conservazione è minima (per esempio scadenza vicina)
        if (tempoConservazione == 1) {
            costo /= 2; // Se il tempo di conservazione è 1, si riduce il prezzo della metà
        }
        return costo;
    }

    /**
     * Restituisce una rappresentazione del prodotto alimentare come stringa.
     * 
     * @return Una stringa che rappresenta il prodotto alimentare.
     */
    @Override
    public String toString() {
        return String.format(
            "Prodotto Alimentare:\nCodice: %s\nPrezzo Iniziale: %.2f\nCosto Calcolato: %.2f\nTempo di Conservazione: %d\nPrincipio Nutritivo: %s",
            getCodice(), getPrezzoIniziale(), calcolaCosto(), tempoConservazione, principioNutritivo
        );
    }
}
