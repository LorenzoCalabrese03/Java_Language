package Esonero.store;

/**
 * La classe ProdottoAlimentare estende la classe Prodotto e rappresenta un prodotto alimentare
 * con attributi aggiuntivi come l'energia e il tempo di conservazione.
 */
public class ProdottoAlimentare extends Prodotto {
    private int energia;
    private int tempoConservazione;

    /**
     * Costruisce un'istanza di ProdottoAlimentare con codice, nome, prezzo, energia e tempo di conservazione specificati.
     *
     * @param codice            il codice univoco del prodotto alimentare
     * @param nome              il nome del prodotto alimentare
     * @param prezzo            il prezzo del prodotto alimentare
     * @param energia           il valore energetico del prodotto alimentare
     * @param tempoConservazione il tempo di conservazione in giorni del prodotto alimentare
     * @throws Errore se il codice o il nome sono nulli o vuoti, se il prezzo o l'energia sono negativi,
     *                o se il tempo di conservazione è inferiore a 1
     */
    public ProdottoAlimentare(String codice, String nome, double prezzo, int energia, int tempoConservazione) throws Errore {
        super(codice, nome, prezzo);
        setEnergia(energia);
        setTempoConservazione(tempoConservazione);
    }

    /**
     * Restituisce il valore energetico del prodotto.
     *
     * @return il valore energetico del prodotto
     */
    public int getEnergia() {
        return energia;
    }

    /**
     * Imposta il valore energetico del prodotto. L'energia non può essere negativa.
     *
     * @param energia il nuovo valore energetico del prodotto
     * @throws Errore se il valore energetico è negativo
     */
    public void setEnergia(int energia) throws Errore {
        if (energia < 0) {
            throw new Errore("L'energia non può essere negativa");
        } else {
            this.energia = energia;
        }
    }

    /**
     * Restituisce il tempo di conservazione del prodotto.
     *
     * @return il tempo di conservazione in giorni
     */
    public int getTempoConservazione() {
        return tempoConservazione;
    }

    /**
     * Imposta il tempo di conservazione del prodotto. Se il valore è inferiore o uguale a 1,
     * viene impostato automaticamente a 1 giorno.
     *
     * @param tempoConservazione il nuovo tempo di conservazione in giorni
     */
    public void setTempoConservazione(int tempoConservazione) {
        this.tempoConservazione = Math.max(tempoConservazione, 1);
    }

    /**
     * Calcola il costo del prodotto alimentare. Se il tempo di conservazione è inferiore o uguale a 2 giorni,
     * il prezzo viene dimezzato.
     *
     * @return il costo calcolato del prodotto alimentare
     */
    @Override
    public double calcolaCosto() {
        double prezzo = super.getPrezzo();
        if (getTempoConservazione() <= 2) {
            prezzo /= 2;
        }
        return prezzo;
    }
}
