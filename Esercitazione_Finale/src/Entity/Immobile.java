package Entity;

import java.io.Serializable;

/**
	 * Classe astratta che rappresenta un immobile con attributi di base come codice,
	 * indirizzo, metri quadri e prezzo. Le sottoclassi concrete devono implementare
	 * il metodo {@code calcolaPrezzo} per determinare la logica di calcolo del prezzo
	 * specifica.
	 */
	public abstract class Immobile implements Serializable{
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private String codiceImmobile;
	    private String indirizzo;
	    private double metriQuadri;
	    private double prezzo;

	    /**
	     * Costruttore della classe Immobile.
	     *
	     * @param codiceImmobile il codice identificativo dell'immobile.
	     * @param indirizzo      l'indirizzo dell'immobile.
	     * @param metriQuadri    la superficie dell'immobile in metri quadri.
	     * @param prezzo         il prezzo dell'immobile.
	     * @throws Errore se uno qualsiasi dei parametri non soddisfa i requisiti di validità.
	     */
	    public Immobile(String codiceImmobile, String indirizzo, double metriQuadri, double prezzo) throws Errore {
	        setCodiceImmobile(codiceImmobile);
	        setIndirizzo(indirizzo);
	        setMetriQuadri(metriQuadri);
	        setPrezzo(prezzo);
	    }

	    /**
	     * Restituisce il codice identificativo dell'immobile.
	     *
	     * @return il codice identificativo dell'immobile.
	     */
	    public String getCodiceImmobile() {
	        return codiceImmobile;
	    }

	    /**
	     * Imposta il codice identificativo dell'immobile.
	     *
	     * @param codiceImmobile il codice identificativo dell'immobile.
	     * @throws Errore se il codice è null o vuoto.
	     */
	    public void setCodiceImmobile(String codiceImmobile) throws Errore {
	        if (codiceImmobile == null || codiceImmobile.isEmpty()) {
	            throw new Errore("Il codice è vuoto");
	        }
	        this.codiceImmobile = codiceImmobile.toLowerCase();
	    }

	    /**
	     * Restituisce l'indirizzo dell'immobile.
	     *
	     * @return l'indirizzo dell'immobile.
	     */
	    public String getIndirizzo() {
	        return indirizzo;
	    }

	    /**
	     * Imposta l'indirizzo dell'immobile.
	     *
	     * @param indirizzo l'indirizzo dell'immobile.
	     * @throws Errore se l'indirizzo è null o vuoto.
	     */
	    public void setIndirizzo(String indirizzo) throws Errore {
	        if (indirizzo == null || indirizzo.isEmpty()) {
	            throw new Errore("L'indirizzo è vuoto");
	        }
	        this.indirizzo = indirizzo;
	    }

	    /**
	     * Restituisce la superficie dell'immobile in metri quadri.
	     *
	     * @return la superficie dell'immobile in metri quadri.
	     */
	    public double getMetriQuadri() {
	        return metriQuadri;
	    }

	    /**
	     * Imposta la superficie dell'immobile in metri quadri.
	     *
	     * @param metriQuadri la superficie in metri quadri dell'immobile.
	     * @throws Errore se la superficie è inferiore o uguale a zero.
	     */
	    public void setMetriQuadri(double metriQuadri) throws Errore {
	        if (metriQuadri <= 0) {
	            throw new Errore("I metri quadri sono negativi o zero");
	        }
	        this.metriQuadri = metriQuadri;
	    }

	    /**
	     * Restituisce il prezzo dell'immobile.
	     *
	     * @return il prezzo dell'immobile.
	     */
	    public double getPrezzo() {
	        return prezzo;
	    }

	    /**
	     * Imposta il prezzo dell'immobile.
	     *
	     * @param prezzo il prezzo dell'immobile.
	     * @throws Errore se il prezzo è inferiore o uguale a zero o inferiore a 5000.
	     */
	    public void setPrezzo(double prezzo) throws Errore {
	        if (prezzo <= 0&&prezzo<5000) {
	            throw new Errore("Il prezzo è negativo o zero");
	        }
	        this.prezzo = prezzo;
	    }

	    /**
	     * Restituisce una descrizione dettagliata dell'immobile, inclusi codice,
	     * indirizzo, metri quadri e prezzo.
	     *
	     * @return un {@link StringBuilder} contenente la descrizione dell'immobile.
	     */
	    public StringBuilder descrizione() {
	        StringBuilder br = new StringBuilder();
	        br.append("Codice: ").append(getCodiceImmobile()).append("\n");
	        br.append("Indirizzo: ").append(getIndirizzo()).append("\n");
	        br.append("Metri quadri: ").append(getMetriQuadri()).append("\n");
	        br.append("Prezzo: ").append(getPrezzo()).append("\n");
	        return br;
	    }

	    /**
	     * Metodo astratto per il calcolo del prezzo dell'immobile. Deve essere
	     * implementato nelle sottoclassi per fornire una logica specifica per il calcolo
	     * del prezzo.
	     *
	     * @return il prezzo calcolato dell'immobile.
	     */
	    public abstract double calcolaPrezzo();
	}


