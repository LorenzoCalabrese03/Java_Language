package Esonero.test;

import Esonero.store.Errore;
import Esonero.store.MagazzinoProdotti;
import Esonero.store.Prodotto;
import Esonero.store.ProdottoAlimentare;

/**
 * La classe MagazzinoTest esegue il test delle funzionalità della classe MagazzinoProdotti,
 * inclusi l'aggiunta, la rimozione, il filtraggio e la ricerca del prodotto con il prezzo più alto.
 */
public class MagazzinoTest {

    /**
     * Metodo principale che esegue il test delle funzionalità di gestione del magazzino prodotti.
     * 
     * @param args gli argomenti della riga di comando (non utilizzati)
     * @throws Errore se si verifica un errore durante l'aggiunta o la rimozione dei prodotti
     */
    public static void main(String[] args) throws Errore {
        MagazzinoProdotti magazzino = new MagazzinoProdotti();
        
        // Creazione di alcuni prodotti e un prodotto alimentare
        Prodotto prodotto1 = new Prodotto("1", "Telefono", 300);
        Prodotto prodotto2 = new Prodotto("2", "Frigorifero", 400);
        ProdottoAlimentare pane = new ProdottoAlimentare("3", "Pane", 2, 300, 5);

        try {
            // Aggiunta dei prodotti al magazzino
            System.out.println("Aggiunta prodotto1: " + magazzino.aggiungiProdotti(prodotto1));
            System.out.println("Aggiunta prodotto2: " + magazzino.aggiungiProdotti(prodotto2));
            System.out.println("Aggiunta pane: " + magazzino.aggiungiProdotti(pane));

            // Stampa descrizione di prodotto1
            System.out.println("Descrizione prodotto1:");
            System.out.println(prodotto1.descrizione());

            // Esempio di chiamata per filtrare i prodotti in base al prezzo
            System.out.println("Lista dei prodotti con prezzo >= 300:");
            magazzino.getLista(1);

            // Esempio di chiamata per ottenere il prodotto con prezzo più alto
            Prodotto prodottoConPrezzoAlto = magazzino.ProdottoPrezzoAlto();
            System.out.println("Prodotto con prezzo più alto:\n" + (prodottoConPrezzoAlto != null ? prodottoConPrezzoAlto.descrizione() : "Nessun prodotto trovato"));

        } catch (Errore e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}
