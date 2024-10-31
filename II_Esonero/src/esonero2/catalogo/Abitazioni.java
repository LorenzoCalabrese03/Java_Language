package esonero2.catalogo;

/**
 * La classe Abitazioni rappresenta un'abitazione con un codice, un luogo e un prezzo.
 * Fornisce metodi per ottenere e impostare queste informazioni e per calcolare
 * il costo dell'abitazione.
 */
public class Abitazioni {
    private String codice;
    private double prezzo;
    private String luogo;

    /**
     * Costruisce un'istanza di Abitazioni con codice, luogo e prezzo specificati.
     *
     * @param codice il codice univoco dell'abitazione
     * @param luogo il luogo in cui si trova l'abitazione
     * @param prezzo il prezzo dell'abitazione
     * @throws Errore se il codice o il luogo sono vuoti o nulli, o se il prezzo è inferiore a 5000
     */
    public Abitazioni(String codice, String luogo, double prezzo) throws Errore {
        setCodice(codice);
        setLuogo(luogo);
        setPrezzo(prezzo);
    }

    /**
     * Restituisce il codice dell'abitazione.
     *
     * @return il codice dell'abitazione
     */
    public String getCodice() {
        return codice;
    }

    /**
     * Restituisce il prezzo dell'abitazione.
     *
     * @return il prezzo dell'abitazione
     */
    public double getPrezzo() {
        return prezzo;
    }

    /**
     * Restituisce il luogo dell'abitazione.
     *
     * @return il luogo dell'abitazione
     */
    public String getLuogo() {
        return luogo;
    }

    /**
     * Imposta il prezzo dell'abitazione. Il prezzo non può essere inferiore a 5000.
     *
     * @param prezzo il nuovo prezzo dell'abitazione
     * @throws Errore se il prezzo è inferiore a 5000
     */
    public void setPrezzo(double prezzo) throws Errore {
        if (prezzo < 5000) {
            throw new Errore("Il prezzo non può essere inferiore a 5000");
        } else {
            this.prezzo = prezzo;
        }
    }

    /**
     * Imposta il codice dell'abitazione. Il codice non può essere nullo o vuoto.
     *
     * @param codice il nuovo codice dell'abitazione
     * @throws Errore se il codice è nullo o vuoto
     */
    public void setCodice(String codice) throws Errore {
        if (codice == null || codice.isEmpty()) {
            throw new Errore("Il codice non può essere vuoto o nullo");
        } else {
            this.codice = codice;
        }
    }

    /**
     * Imposta il luogo dell'abitazione. Il luogo non può essere nullo o vuoto.
     *
     * @param luogo il nuovo luogo dell'abitazione
     * @throws Errore se il luogo è nullo o vuoto
     */
    public void setLuogo(String luogo) throws Errore {
        if (luogo == null || luogo.isEmpty()) {
            throw new Errore("Il luogo non può essere vuoto o nullo");
        } else {
            this.luogo = luogo;
        }
    }

    /**
     * Calcola il costo dell'abitazione.
     *
     * @return il prezzo dell'abitazione
     */
    public double calcolaCosto() {
        return prezzo;
    }

    /**
     * Restituisce una descrizione dettagliata dell'abitazione.
     *
     * @return una rappresentazione dettagliata dell'abitazione
     */
    public StringBuilder descrizione() {
        StringBuilder br = new StringBuilder();
        br.append("Codice: ").append(getCodice()).append("\n");
        br.append("Luogo: ").append(getLuogo()).append("\n");
        br.append("Prezzo: ").append(calcolaCosto());
        return br;
    }
}
