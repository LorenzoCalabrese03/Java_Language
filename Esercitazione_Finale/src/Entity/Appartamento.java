package Entity;

import java.io.Serializable;

/**
 * La classe Appartamento rappresenta un tipo specifico di Immobile con l'attributo aggiuntivo
 * del numero di stanze. Estende la classe {@link Immobile} e implementa una logica
 * specifica per il calcolo del prezzo, considerando il numero di stanze.
 */
public class Appartamento extends Immobile implements Serializable {
    private int numStanze;

    /**
     * Costruttore della classe Appartamento.
     *
     * @param codiceImmobile il codice identificativo dell'appartamento.
     * @param indirizzo      l'indirizzo dell'appartamento.
     * @param metriQuadri    la superficie dell'appartamento in metri quadri.
     * @param prezzo         il prezzo base dell'appartamento.
     * @param numStanze      il numero di stanze dell'appartamento.
     * @throws Errore se uno qualsiasi dei parametri non soddisfa i requisiti di validità.
     */
    public Appartamento(String codiceImmobile, String indirizzo, double metriQuadri, double prezzo, int numStanze) throws Errore {
        super(codiceImmobile, indirizzo, metriQuadri, prezzo);
        setNumStanze(numStanze);
    }
    
	/**
     * Restituisce il numero di stanze dell'appartamento.
     *
     * @return il numero di stanze dell'appartamento.
     */
    public int getNumStanze() {
        return numStanze;
    }

    /**
     * Imposta il numero di stanze dell'appartamento.
     *
     * @param numStanze il numero di stanze dell'appartamento.
     * @throws Errore se il numero di stanze è minore o uguale a zero.
     */
    public void setNumStanze(int numStanze) throws Errore {
        if (numStanze <= 0) {
            throw new Errore("Il numero delle stanze è negativo o zero");
        }
        this.numStanze = numStanze;
    }

    /**
     * Restituisce una descrizione dettagliata dell'appartamento, inclusi il numero
     * di stanze, codice, indirizzo, metri quadri e prezzo.
     *
     * @return un {@link StringBuilder} contenente la descrizione completa dell'appartamento.
     */
    @Override
    public StringBuilder descrizione() {
        return super.descrizione().append("Numero Stanze: ").append(getNumStanze()).append("\n");
    }

    /**
     * Calcola il prezzo dell'appartamento, applicando un incremento del 15% se il
     * numero di stanze è superiore a 3.
     *
     * @return il prezzo calcolato dell'appartamento.
     */
    @Override
    public double calcolaPrezzo() {
        double prezzo = super.getPrezzo();
        if (getNumStanze() > 3) {
            prezzo += super.getPrezzo() * 0.15;
        }
        return prezzo;
    }
}
