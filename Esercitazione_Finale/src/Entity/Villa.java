package Entity;

import java.io.Serializable;

/**
 * La classe Villa rappresenta un tipo di abitazione con caratteristiche di base 
 * di un appartamento e un'area giardino aggiuntiva. Estende {@link Appartamento}
 * e aggiunge una logica specifica per il calcolo del costo basata sulla superficie del giardino.
 */
public class Villa extends Immobile implements Serializable{
    private double metriGiardino;

    /**
     * Costruttore della classe Villa.
     *
     * @param codice         il codice identificativo della villa.
     * @param costo          il costo base della villa.
     * @param luogo          il luogo dove si trova la villa.
     * @param metriQuadri	 i metri quadri dell'abitazione
     * @param metriGiardino  la superficie del giardino in metri quadri.
     * @throws Errore se uno qualsiasi dei parametri non soddisfa i requisiti di validità.
     */
    public Villa(String codice,  String luogo,double costo,double metriQuadri,  double metriGiardino) throws Errore {
    	super(codice, luogo, costo, metriQuadri);
        setMetriGiaridino(metriGiardino);
    }

    /**
     * Restituisce la superficie del giardino in metri quadri.
     *
     * @return la superficie del giardino in metri quadri.
     */
    public double getMetriGiaridino() {
        return metriGiardino;
    }

    /**
     * Imposta la superficie del giardino in metri quadri. Se il valore è inferiore
     * a 5 metri quadri, imposta automaticamente la superficie a 5.0 metri quadri.
     *
     * @param metriGiardino la superficie del giardino in metri quadri.
     */
    public void setMetriGiaridino(double metriGiardino) {
        if (metriGiardino < 5.0) {
            this.metriGiardino = 5.0;
        } else {
            this.metriGiardino = metriGiardino;
        }
    }

    /**
     * Calcola il costo della villa, applicando un incremento del 150% se la superficie
     * del giardino supera i 50 metri quadri.
     *
     * @return il costo calcolato della villa.
     */


	@Override
	public double calcolaPrezzo() {
		 if (getMetriGiaridino() > 50.0) {
	            return super.getPrezzo() + (super.getPrezzo() * 1.5);
	        }
	        return super.getPrezzo();
	}
    /**
     * Restituisce una descrizione dettagliata dell'appartamento, inclusi il numero
     * di stanze, codice, indirizzo, metri quadri e prezzo.
     *
     * @return un {@link StringBuilder} contenente la descrizione completa dell'appartamento.
     */
    @Override
    public StringBuilder descrizione() {
        return super.descrizione().append("Metri giardino: ").append(getMetriGiaridino()).append("\n");
    }
}
