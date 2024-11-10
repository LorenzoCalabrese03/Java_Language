package Entity;

/**
 * La classe ProdottoExeption è una sottoclasse di Exception che rappresenta un'eccezione specifica
 * per la gestione di errori relativi ai prodotti. Questa eccezione viene sollevata quando si
 * verificano condizioni non valide, come un costo negativo o un nome non valido.
 */
public class ProdottoExeption extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * Costruttore per creare un'eccezione ProdottoExeption con un messaggio specificato.
     * 
     * @param message Il messaggio di errore che descrive il motivo dell'eccezione.
     */
    public ProdottoExeption(String message) {
        super(message);
    }
}
