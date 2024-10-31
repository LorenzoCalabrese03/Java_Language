package esonero2.test;

import java.util.Scanner;
import esonero2.catalogo.Abitazioni;
import esonero2.catalogo.Catalogo;
import esonero2.catalogo.Errore;
import esonero2.catalogo.Ville;

/**
 * La classe CatalogoTest testa le funzionalità della classe Catalogo,
 * includendo l'aggiunta, la rimozione, e il filtraggio di abitazioni e ville.
 */
public class CatalogoTest {

    /**
     * Metodo principale che esegue il test delle funzionalità di gestione del catalogo.
     * 
     * @param args gli argomenti della riga di comando (non utilizzati)
     * @throws Errore se si verifica un errore durante l'aggiunta o la rimozione delle abitazioni
     */
    public static void main(String[] args) {
        try {
            // Creazione di oggetti Abitazioni e Ville
            Abitazioni abitazione1 = new Ville("1", "Milano", 50000, 30);
            Abitazioni abitazione2 = new Ville("2", "Roma", 70000, 40);
            Abitazioni abitazione3 = new Ville("4", "Taranto", 55000, 25);
            Ville villa1 = new Ville("4", "Firenze", 10000, 60);
            Ville villa2 = new Ville("5", "Roma", 12000, 70);

            // Creazione del catalogo e aggiunta delle abitazioni
            Catalogo catalogo = new Catalogo();
            System.out.println(catalogo.aggiungiAlCatalogo(abitazione1)); // Aggiunge abitazione1
            System.out.println(catalogo.aggiungiAlCatalogo(abitazione2)); // Aggiunge abitazione2
            System.out.println(catalogo.aggiungiAlCatalogo(abitazione3)); // Aggiunge abitazione3
            System.out.println(catalogo.aggiungiAlCatalogo(villa1));      // Aggiunge villa1
            System.out.println(catalogo.aggiungiAlCatalogo(villa2));      // Aggiunge villa2

            // Selezione del metodo di filtraggio
            System.out.println("Seleziona il metodo di filtraggio:\n<1> By prezzo\n<2> By luogo\n>");
            Scanner scanner = new Scanner(System.in);
            int scelta = scanner.nextInt();
            
            // Verifica che la scelta sia valida
            if (scelta == 1 || scelta == 2) {
                catalogo.getElenco(scelta); // Filtra le abitazioni in base alla scelta
            } else {
            	scanner.close();
                throw new Errore("Scelta non valida. Per favore, scegli 1 o 2.");
            }
            scanner.close();

            // Rimozione di un'abitazione per codice
            System.out.println("Rimozione villa con codice '3': " + catalogo.rimuoviAbitazioneByCodice("3")); // rimozione villa1

        } catch (Errore e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}
