package Entity.test;

import java.util.List;
import java.util.Scanner;
import Entity.Appartamento;
import Entity.Catalogo;
import Entity.Errore;
import Entity.Immobile;
import Entity.Villa;
import File.Serializzazione;

/**
 * Classe di test per la gestione del catalogo delle abitazioni.
 * Esegue operazioni di aggiunta, ricerca e rimozione di abitazioni all'interno
 * di un catalogo e mostra i risultati in base a criteri specifici.
 * Permette l'inserimento interattivo di abitazioni e fornisce metodi per testare
 * l'interfaccia del catalogo. Utilizza la serializzazione per salvare e caricare
 * i dati delle abitazioni in un file binario.
 * 
 * @version 1.0
 * @since 2024-11-09
 */
public class CatalogoTest {

    /**
     * Metodo principale per eseguire i test sulla classe Catalogo.
     * Consente l'inserimento interattivo delle abitazioni, visualizza gli elenchi 
     * di abitazioni in base a criteri di ricerca, e rimuove un'abitazione specifica.
     * Inoltre, salva i dati delle abitazioni in un file tramite serializzazione e 
     * carica i dati dal file per visualizzare le informazioni caricate.
     *
     * @param args argomenti della linea di comando (non utilizzati).
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {  // try-with-resources per chiudere scanner
            Catalogo catalogo = new Catalogo();
            String nomeFile = "C:\\Users\\loren\\eclipse-workspace\\Test_Velocità_II\\src\\File\\Risultati_Ricerca.txt";

            // Popola il catalogo con dati di test
            aggiungiAbitazioniDiTest(catalogo);

            // Serializza e salva la lista di abitazioni con costo superiore a 50000
            List<Immobile> listaAbitazioni = catalogo.getElenco(1, 50000.0);
            Serializzazione.salvaAbitazioniSerializzate(listaAbitazioni, nomeFile);

            // Deserializza e carica i dati dal file
            List<Immobile> abitazioniDalFile = Serializzazione.caricaAbitazioniSerializzate(nomeFile);
            stampa(abitazioniDalFile, "Prezzo");

            // Rimuove un'abitazione specifica
            System.out.println("Rimozione abitazione con codice 'asdb': " + catalogo.rimuoviAbitazioneByCodice("asdb"));

        } catch (Errore e) {
            System.out.print("Errore: " + e.getMessage());
        }
    }

    /**
     * Metodo che consente di aggiungere abitazioni al catalogo tramite input interattivo.
     * Richiede all'utente di inserire il codice, il luogo, il costo e il numero di stanze per 
     * ogni abitazione e aggiunge l'abitazione al catalogo. Consente all'utente di aggiungere più abitazioni.
     *
     * @param catalogo il catalogo a cui aggiungere le abitazioni.
     * @param scanner  il {@link Scanner} utilizzato per leggere l'input dell'utente.
     */
    private static void aggiungiAbitazioniInterattivo(Catalogo catalogo, Scanner scanner) {
        String risposta = "Y";
        while (risposta.equalsIgnoreCase("Y")) {
            try {
                System.out.println("Inserisci il codice abitazione:");
                String codice = scanner.nextLine();

                System.out.println("Inserisci il luogo abitazione:");
                String luogo = scanner.nextLine();

                System.out.println("Inserisci il costo abitazione:");
                double costo = scanner.nextDouble();
                scanner.nextLine(); // Consuma il newline rimanente

                System.out.println("Inserisci il numero di stanze:");
                int stanze = scanner.nextInt();
                scanner.nextLine(); // Consuma il newline rimanente

                Appartamento abitazione = new Appartamento(codice, luogo, 50, costo, stanze);
                System.out.println("Aggiunta riuscita: " + catalogo.aggiungiAbitazione(abitazione));

                System.out.println("Desideri aggiungere un'altra abitazione? (Y/N)");
                risposta = scanner.nextLine();
            } catch (Errore e) {
                System.out.println("Errore: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Si è verificato un errore: " + e.getMessage());
                scanner.nextLine(); // Consuma il newline rimanente
            }
        }
    }

    /**
     * Metodo che aggiunge un insieme di abitazioni di test al catalogo.
     * Utilizzato per popolare il catalogo con dati predefiniti a fini di test.
     *
     * @param catalogo il catalogo a cui aggiungere le abitazioni di test.
     */
    private static void aggiungiAbitazioniDiTest(Catalogo catalogo) {
        try {
            Appartamento abitazione = new Appartamento("Asdas", "Milano", 50, 50000, 3);
            Appartamento abitazione1 = new Appartamento("Asdc", "Milano", 50, 52000, 3);
            Appartamento abitazione2 = new Appartamento("Asdb", "Napoli", 50, 56000, 3);
            Villa villa1 = new Villa("asdf", "Napoli", 56000, 51, 50);

            catalogo.aggiungiAbitazione(abitazione);
            catalogo.aggiungiAbitazione(abitazione1);
            catalogo.aggiungiAbitazione(abitazione2);
            catalogo.aggiungiAbitazione(villa1);

        } catch (Errore e) {
            System.out.println("Errore durante l'aggiunta di abitazioni di test: " + e.getMessage());
        }
    }

    /**
     * Stampa una lista di abitazioni in base a un criterio di ricerca specifico.
     * Visualizza i dettagli di ogni abitazione nella lista.
     *
     * @param listaAbitazioni la lista delle abitazioni da stampare.
     * @param criterio        il criterio di ricerca utilizzato per filtrare la lista.
     */
    private static void stampa(List<Immobile> listaAbitazioni, String criterio) {
        System.out.println("Risultati ricerca per: " + criterio);
        for (Immobile abitazione : listaAbitazioni) {
            System.out.println(abitazione.descrizione());
        }
    }
}
