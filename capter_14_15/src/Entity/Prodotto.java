package Entity;

/**
 * La classe Prodotto rappresenta un prodotto generico con un costo, un codice identificativo e un nome.
 * Contiene metodi per gestire e validare le proprietà del prodotto.
 */
public class Prodotto {
    double costo;
    Integer codice;
    String nome;

    /**
     * Costruttore per creare un oggetto Prodotto.
     * 
     * @param codice Il codice identificativo del prodotto.
     * @param costo  Il costo del prodotto.
     * @param nome   Il nome del prodotto.
     * @throws ProdottoExeption se il nome è troppo corto o se il costo è negativo.
     */
    public Prodotto(Integer codice, double costo, String nome) throws ProdottoExeption {
        this.setCodice(codice);
        try {
            controlloNome(nome);
            this.setNome(nome);
            costoNegativo(costo);
            this.setCosto(costo);
        } catch (ProdottoExeption e) {
            System.out.print(e);
        }
    }

    /**
     * Restituisce il nome del prodotto.
     * 
     * @return il nome del prodotto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Imposta il nome del prodotto.
     * 
     * @param nome il nome del prodotto.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Restituisce il codice identificativo del prodotto.
     * 
     * @return il codice del prodotto.
     */
    public Integer getCodice() {
        return codice;
    }

    /**
     * Imposta il codice identificativo del prodotto.
     * 
     * @param codice il codice del prodotto.
     */
    public void setCodice(Integer codice) {
        this.codice = codice;
    }

    /**
     * Restituisce il costo del prodotto.
     * 
     * @return il costo del prodotto.
     */
    public double getCosto() {
        return costo;
    }

    /**
     * Imposta il costo del prodotto.
     * 
     * @param costo il costo del prodotto.
     */
    public void setCosto(double costo) {
        this.costo = costo;
    }

    /**
     * Restituisce una descrizione completa del prodotto.
     * 
     * @return una stringa contenente il codice, il nome e il costo del prodotto.
     */
    public String descrizione() {
        StringBuilder sb = new StringBuilder();
        sb.append("Codice: ").append(codice).append("\n");
        sb.append("Nome: ").append(nome).append("\n");
        sb.append("Costo: €").append(costo).append("\n");
        return sb.toString();
    }

    /**
     * Calcola e restituisce il costo del prodotto.
     * 
     * @return il costo del prodotto.
     */
    public double calcolaCosto() {
        return costo;
    }

    /**
     * Verifica se il costo è negativo.
     * 
     * @param costo Il costo da verificare.
     * @throws ProdottoExeption se il costo è negativo.
     */
    public static void costoNegativo(double costo) throws ProdottoExeption {
        if (costo < 0) {
            throw new ProdottoExeption("Il costo non può essere negativo");
        }
    }

    /**
     * Verifica se il nome è valido (deve contenere almeno 3 caratteri).
     * 
     * @param nome Il nome del prodotto da verificare.
     * @throws ProdottoExeption se il nome è troppo corto.
     */
    public static void controlloNome(String nome) throws ProdottoExeption {
        if (nome.isEmpty() || nome.length() < 3) {
            throw new ProdottoExeption("Il prodotto non può essere inferiore a 3 caratteri\n");
        }
    }
}
