package esonero2.catalogo;

/**
 * La classe Ville rappresenta un'abitazione di tipo villa, che estende la classe Abitazioni.
 * Oltre ai campi ereditati da Abitazioni, include un campo per la misura del giardino in metri quadrati.
 */
public class Ville extends Abitazioni {
    private double metriGiardino;

    /**
     * Costruisce un'istanza di Ville con codice, luogo, prezzo e metri quadrati del giardino specificati.
     *
     * @param codice        il codice univoco della villa
     * @param luogo         il luogo in cui si trova la villa
     * @param prezzo        il prezzo della villa
     * @param metriGiardino la dimensione del giardino in metri quadrati
     * @throws Errore se il codice o il luogo sono vuoti o nulli, se il prezzo è inferiore a 5000,
     *                o se i metri quadrati del giardino sono negativi
     */
    public Ville(String codice, String luogo, double prezzo, double metriGiardino) throws Errore {
        super(codice, luogo, prezzo);
        setMetriGiardino(metriGiardino);
    }

    /**
     * Restituisce la dimensione del giardino in metri quadrati.
     *
     * @return la dimensione del giardino in metri quadrati
     */
    public double getMetriGiardino() {
        return metriGiardino;
    }

    /**
     * Imposta la dimensione del giardino in metri quadrati.
     * Se la dimensione specificata è inferiore a 5.0, viene impostata a 5.0.
     *
     * @param metriGiardino la nuova dimensione del giardino in metri quadrati
     * @throws Errore se i metri quadrati specificati sono negativi
     */
    public void setMetriGiardino(double metriGiardino) throws Errore {
        if (metriGiardino < 0) {
            throw new Errore("I metri quadrati non possono essere < 0");
        } else if (metriGiardino < 5.0) {
            this.metriGiardino = 5.0;
        } else {
            this.metriGiardino = metriGiardino;
        }
    }

    /**
     * Calcola il costo della villa. Se il giardino è più grande di 50 metri quadrati,
     * il costo viene aumentato del 150%.
     *
     * @return il costo calcolato della villa
     */
    @Override
    public double calcolaCosto() {
        double prezzo = super.getPrezzo();
        if (getMetriGiardino() > 50) {
            return prezzo * 1.5;
        } else {
            return prezzo;
        }
    }
}
