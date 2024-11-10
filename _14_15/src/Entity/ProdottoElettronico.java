package Entity;

/**
 * La classe ProdottoElettronico estende la classe Prodotto e rappresenta un prodotto elettronico con una garanzia specifica.
 * Questa classe include metodi per calcolare il costo in base alla durata della garanzia e per verificare la validità della garanzia.
 */
public class ProdottoElettronico extends Prodotto {
    int garanzia;

    /**
     * Costruttore per creare un oggetto ProdottoElettronico.
     * 
     * @param codice   Il codice identificativo del prodotto.
     * @param costo    Il costo del prodotto.
     * @param nome     Il nome del prodotto.
     * @param garanzia La durata della garanzia in mesi.
     * @throws ProdottoExeption se la garanzia non è valida.
     */
    public ProdottoElettronico(Integer codice, double costo, String nome, int garanzia) throws ProdottoExeption {
        super(codice, costo, nome);
        try {
            controlloGaranzia(garanzia);
            this.setGaranzia(garanzia);
        } catch (ProdottoExeption e) {
            System.out.println(e);
            this.setGaranzia(2);
        }
    }

    /**
     * Restituisce la durata della garanzia.
     * 
     * @return la durata della garanzia in mesi.
     */
    public int getGaranzia() {
        return garanzia;
    }

    /**
     * Imposta la durata della garanzia.
     * 
     * @param garanzia la durata della garanzia in mesi.
     */
    public void setGaranzia(int garanzia) {
        this.garanzia = garanzia;
    }

    /**
     * Calcola il costo del prodotto in base alla durata della garanzia.
     * Se la garanzia è maggiore o uguale a 12 mesi, viene applicato uno sconto del 10% sul costo.
     * 
     * @return il costo del prodotto dopo l'eventuale sconto.
     */
    @Override
    public double calcolaCosto() {
        double NewCosto = super.getCosto();
        if (getGaranzia() >= 12) {
            return NewCosto * 0.1;
        } else {
            return NewCosto;
        }
    }

    /**
     * Controlla se la garanzia è valida (deve essere compresa tra 2 e 24 mesi).
     * 
     * @param garanzia La durata della garanzia da verificare.
     * @throws ProdottoExeption se la garanzia non è compresa nell'intervallo specificato.
     */
    public static void controlloGaranzia(int garanzia) throws ProdottoExeption {
        if (garanzia < 2 || garanzia > 24) {
            throw new ProdottoExeption("La garanzia non è compresa nell'intervallo\nGli verrà dato il valore di default");
        }
    }

    /**
     * Restituisce una descrizione completa del prodotto elettronico, inclusa la durata della garanzia.
     * 
     * @return una stringa contenente la descrizione del prodotto e la durata della garanzia.
     */
    @Override
    public String descrizione() {
        StringBuilder sb = new StringBuilder(super.descrizione());
        sb.append("Garanzia: ").append(getGaranzia()).append(" mesi\n");
        return sb.toString();
    }
}
