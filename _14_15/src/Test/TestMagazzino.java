package Test;

import Entity.Magazzino;
import Entity.ProdottoAlimentare;
import Entity.ProdottoElettronico;
import Entity.ProdottoExeption;

/**
 * La classe TestMagazzino contiene un metodo main per eseguire test sulla classe Magazzino e
 * le sue interazioni con ProdottoAlimentare e ProdottoElettronico. Questa classe permette di testare
 * l'aggiunta, la rimozione e la ricerca di prodotti in base a diversi criteri.
 */
public class TestMagazzino {

    /**
     * Metodo principale per testare le funzionalità della classe Magazzino.
     * 
     * @param args Argomenti della riga di comando (non utilizzati).
     * @throws ProdottoExeption se si verifica un'eccezione durante la creazione o manipolazione dei prodotti.
     */
    public static void main(String[] args) throws ProdottoExeption {
        // Creazione di un oggetto Magazzino per gestire i prodotti
        Magazzino magazzino = new Magazzino();

        // Creazione di oggetti ProdottoAlimentare e ProdottoElettronico
        ProdottoAlimentare Pasta = new ProdottoAlimentare(1, 8.5, "Pasta", 5, 150);
        ProdottoAlimentare Pasta2 = new ProdottoAlimentare(8, 7.5, "Pasta", 6, 200);
        ProdottoAlimentare Frutta = new ProdottoAlimentare(5, 3, "Frutta", 3, 120);
        ProdottoElettronico LapTop = new ProdottoElettronico(2, 1200, "Laptop", 24);
        ProdottoElettronico SmartPhone = new ProdottoElettronico(3, 800, "SmartPhone", 14);
        ProdottoElettronico ab = new ProdottoElettronico(4, 800, "ab", 12);

        // Test aggiunta dei prodotti al magazzino
        System.out.println(magazzino.aggiungiProdotto(Pasta));
        System.out.println(magazzino.aggiungiProdotto(LapTop));
        System.out.println(magazzino.aggiungiProdotto(SmartPhone));
        System.out.println(magazzino.aggiungiProdotto(Pasta2));
        System.out.println(magazzino.aggiungiProdotto(Frutta));
        System.out.println(magazzino.aggiungiProdotto(ab));

        // Test di ricerca di un prodotto per nome
        magazzino.getProdottiByNome("frutta");

        // Test di ricerca di un prodotto per codice
        magazzino.searchByCodice(2);

        // Test di cancellazione dei prodotti in base al costo
        System.out.println(magazzino.cancellaProdottiByCosto(1.5));

        // Test di visualizzazione dei prodotti con un costo superiore a un valore specificato
        magazzino.getProdottiCostoSuperiore(3);

        // Test di ordinamento e visualizzazione dei prodotti per nome e costo decrescente
        magazzino.getProdottiByNomeOrdinatiPerCosto("Pasta");
    }
}
