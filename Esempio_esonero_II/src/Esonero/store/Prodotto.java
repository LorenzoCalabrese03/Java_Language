package Esonero.store;

/**
 * La classe Prodotto rappresenta un prodotto generico, con un codice identificativo,
 * un prezzo e un nome. Fornisce metodi per ottenere e impostare queste informazioni
 * e per calcolare il costo del prodotto.
 */
public class Prodotto {
    private String codice;
    private double prezzo;
    private String nome;

    /**
     * Costruisce un'istanza di Prodotto con codice, nome e prezzo specificati.
     *
     * @param codice il codice univoco del prodotto
     * @param nome   il nome del prodotto
     * @param prezzo il prezzo del prodotto
     * @throws Errore se il codice o il nome sono nulli o vuoti, o se il prezzo è negativo
     */
    public Prodotto(String codice, String nome, double prezzo) throws Errore {
        setCodice(codice);
        setPrezzo(prezzo);
        setNome(nome);
    }

    /**
     * Restituisce il codice del prodotto.
     *
     * @return il codice del prodotto
     */
    public String getCodice() {
        return codice;
    }

    /**
     * Imposta il codice del prodotto. Il codice non può essere nullo o vuoto.
     *
     * @param codice il nuovo codice del prodotto
     * @throws Errore se il codice è nullo o vuoto
     */
    public void setCodice(String codice) throws Errore {
        if (codice == null || codice.isEmpty()) {
            throw new Errore("Il codice del prodotto non può essere nullo o vuoto");
        } else {
            this.codice = codice;
        }
    }

    /**
     * Restituisce il prezzo del prodotto.
     *
     * @return il prezzo del prodotto
     */
    public double getPrezzo() {
        return prezzo;
    }

    /**
     * Imposta il prezzo del prodotto. Il prezzo non può essere negativo.
     *
     * @param prezzo il nuovo prezzo del prodotto
     * @throws Errore se il prezzo è negativo
     */
    public void setPrezzo(double prezzo) throws Errore {
        if (prezzo < 0) {
            throw new Errore("Il costo non può essere negativo");
        } else {
            this.prezzo = prezzo;
        }
    }

    /**
     * Restituisce il nome del prodotto.
     *
     * @return il nome del prodotto
     */
    public String getNome() {
        return nome;
    }

    /**
     * Imposta il nome del prodotto. Il nome non può essere nullo o vuoto.
     *
     * @param nome il nuovo nome del prodotto
     * @throws Errore se il nome è nullo o vuoto
     */
    public void setNome(String nome) throws Errore {
        if (nome == null || nome.isEmpty()) {
            throw new Errore("Il nome non può essere vuoto");
        } else {
            this.nome = nome;
        }
    }

    /**
     * Calcola il costo del prodotto.
     *
     * @return il prezzo del prodotto
     */
    public double calcolaCosto() {
        return prezzo;
    }

    /**
     * Restituisce una descrizione dettagliata del prodotto.
     *
     * @return una rappresentazione dettagliata del prodotto sotto forma di StringBuilder
     */
    public StringBuilder descrizione() {
        StringBuilder br = new StringBuilder();
        br.append("Codice: ").append(getCodice()).append("\n");
        br.append("Nome: ").append(getNome()).append("\n");
        br.append("Prezzo: ").append(calcolaCosto()).append("\n");
        return br;
    }
}
