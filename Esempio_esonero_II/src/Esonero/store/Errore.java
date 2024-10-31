package Esonero.store;

/**
 * La classe Errore rappresenta un'eccezione personalizzata utilizzata per gestire
 * errori specifici relativi ai prodotti e alla gestione del magazzino.
 * Estende la classe Exception e permette di definire messaggi di errore personalizzati.
 */
public class Errore extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * Costruisce un'istanza di Errore con un messaggio specificato.
     *
     * @param messaggio il messaggio di dettaglio per l'errore
     */
    Errore(String messaggio) {
        super(messaggio);
    }
}
