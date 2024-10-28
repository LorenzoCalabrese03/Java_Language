package Entity;

/**
 * La classe ProdottoAlimentare estende la classe Prodotto e rappresenta un prodotto alimentare
 * con proprietà aggiuntive come l'energia e il tempo di conservazione.
 * Contiene metodi per gestire e calcolare il costo del prodotto in base al tempo di conservazione.
 */
public class ProdottoAlimentare extends Prodotto {

    int energia;
    int tempoConservazione;

    /**
     * Costruttore per creare un oggetto ProdottoAlimentare.
     * 
     * @param codice             Il codice identificativo del prodotto.
     * @param costo              Il costo del prodotto.
     * @param nome               Il nome del prodotto.
     * @param energia            Il valore energetico del prodotto in kcal.
     * @param tempoConservazione La durata di conservazione del prodotto in mesi.
     * @throws ProdottoExeption se l'energia o il tempo di conservazione non sono validi.
     */
    public ProdottoAlimentare(Integer codice, double costo, String nome, int energia, int tempoConservazione) throws ProdottoExeption {
        super(codice, costo, nome);
        this.setEnergia(energia);
        this.setTempoConservazione(tempoConservazione);
    }

    /**
     * Restituisce il valore energetico del prodotto.
     * 
     * @return l'energia del prodotto in kcal.
     */
    public int getEnergia() {
        return energia;
    }

    /**
     * Imposta il valore energetico del prodotto.
     * 
     * @param energia l'energia del prodotto in kcal.
     */
    public void setEnergia(int energia) {
        try {
            energiaNegativo(energia);
            this.energia = energia;
        } catch (ProdottoExeption e) {
            // Eccezione gestita senza modifica dell'energia
        }
    }

    /**
     * Restituisce il tempo di conservazione del prodotto.
     * 
     * @return il tempo di conservazione in mesi.
     */
    public int getTempoConservazione() {
        return tempoConservazione;
    }

    /**
     * Imposta il tempo di conservazione del prodotto.
     * 
     * @param tempoConservazione il tempo di conservazione in mesi.
     */
    public void setTempoConservazione(int tempoConservazione) {
        try {
            tempoConservazione(tempoConservazione);
            this.tempoConservazione = tempoConservazione;
        } catch (ProdottoExeption e) {
            this.tempoConservazione = 1;
        }
    }

    /**
     * Calcola il costo del prodotto in base al tempo di conservazione.
     * Se il tempo di conservazione è inferiore o uguale a 2 mesi, il costo viene dimezzato.
     * 
     * @return il costo aggiornato del prodotto.
     */
    @Override
    public double calcolaCosto() {
        double NewCosto = super.getCosto();
        if (getTempoConservazione() <= 2) {
            NewCosto /= 2;
        }
        return NewCosto;
    }

    /**
     * Controlla se il valore energetico è negativo.
     * 
     * @param energia Il valore energetico da verificare.
     * @throws ProdottoExeption se il valore energetico è negativo.
     */
    public static void energiaNegativo(int energia) throws ProdottoExeption {
        if (energia < 0) {
            throw new ProdottoExeption("L'energia non può essere negativa");
        }
    }

    /**
     * Controlla se il tempo di conservazione è valido (maggiore o uguale a 1 mese).
     * 
     * @param tempoConservazione Il tempo di conservazione da verificare.
     * @throws ProdottoExeption se il tempo di conservazione è inferiore a 1.
     */
    public static void tempoConservazione(int tempoConservazione) throws ProdottoExeption {
        if (tempoConservazione < 1) {
            throw new ProdottoExeption("Il tempo di conservazione è inferiore a 1\ngli verrà dato un valore di default");
        }
    }

    /**
     * Restituisce una descrizione completa del prodotto alimentare, inclusi energia e tempo di conservazione.
     * 
     * @return una stringa contenente la descrizione del prodotto, energia e tempo di conservazione.
     */
    @Override
    public String descrizione() {
        StringBuilder sb = new StringBuilder(super.descrizione());
        sb.append("Tempo conservazione: ").append(getTempoConservazione()).append("\n");
        sb.append("Energia: ").append(getEnergia()).append("\n");
        return sb.toString();
    }
}
