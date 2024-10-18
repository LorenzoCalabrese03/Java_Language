package Negozio.test;

import java.util.Scanner;
import Entity.test.Fattura;
import Entity.test.Negozio;
import Entity.test.Pagamento;
import Entity.test.prodottiElettronici;
import Entity.test.prodottoAlimentare;

public class main {

    // Costanti per la scelta del tipo di prodotto
    private static final int PRODOTTO_ELETTRONICO = 1;
    private static final int PRODOTTO_ALIMENTARE = 2;

    public static void main(String[] args) {
        // Dichiarazioni e inizializzazioni delle variabili principali
        Negozio negozio = new Negozio();
        Fattura fattura = new Fattura();
        Scanner scanner = new Scanner(System.in);

        // Ciclo per inserimento prodotti
        String risposta;
        do {
            System.out.println("Desideri inserire un prodotto? (Yes|No)");
            risposta = scanner.nextLine().toLowerCase();

            if (risposta.equals("yes")) {
                Scelta(scanner, negozio);
            }

        } while (risposta.equals("yes"));

        // Scelta della tipologia di fattura
        System.out.println("Seleziona l'articolo per la fattura:\n>1 (Elettronici)\n>2 (Alimentari)");
        int sceltaFattura = scanner.nextInt();

        // Calcolo della fattura in base alla scelta della categoria
        fattura.setNumArticoli(negozio.calcoloQuantità(sceltaFattura));
        fattura.setPrezzoUnita(negozio.calcoloImportoUni(sceltaFattura));

        // Aggiunta della fattura alla lista delle fatture
        negozio.addFattura(fattura);

        // Calcolo e stampa del totale dei prodotti
        double totaleImporto = 0;
        for (Pagamento entry : negozio.getAllPagamenti()) {
            totaleImporto += entry.calcoloImporto();
        }
        System.out.println("Totale importo dei prodotti: " + totaleImporto);

        // Chiusura dello scanner
        scanner.close();
    }

    /**
     * Funzione per l'inserimento di un prodotto nel negozio in modo ripetitivo.
     * @param scanner Lo scanner per la lettura degli input dell'utente.
     * @param negozio L'oggetto negozio in cui aggiungere i prodotti.
     */
    public static void Scelta(Scanner scanner, Negozio negozio) {
        System.out.println("Quale tipologia di prodotto vuoi registrare:");
        System.out.println("<1> Elettronico\n<2> Alimentare");
        System.out.print("Scelta: ");

        // Variabili per raccogliere i dati del prodotto
        String codice;
        double prezzo;
        int scelta = scanner.nextInt();
        scanner.nextLine();  // Consuma il newline rimasto dopo la lettura di nextInt()

        switch (scelta) {
            case PRODOTTO_ELETTRONICO:
                // Inserimento di un prodotto elettronico
                System.out.print("Digita il codice del prodotto: ");
                codice = scanner.nextLine();
                
                System.out.print("Digita il prezzo del prodotto: ");
                prezzo = scanner.nextDouble();
                scanner.nextLine();  // Consuma il newline dopo nextDouble()

                System.out.print("Digita i mesi di garanzia del prodotto: ");
                int garanzia = scanner.nextInt();
                scanner.nextLine();  // Consuma il newline

                // Creazione del prodotto elettronico
                prodottiElettronici prodottoEle = new prodottiElettronici(codice, prezzo, garanzia);
                negozio.addProdotto(prodottoEle);
                System.out.println("Prodotto elettronico aggiunto con successo.");
                break;

            case PRODOTTO_ALIMENTARE:
                // Inserimento di un prodotto alimentare
                System.out.print("Digita il codice del prodotto: ");
                codice = scanner.nextLine();
                
                System.out.print("Digita il prezzo del prodotto: ");
                prezzo = scanner.nextDouble();
                scanner.nextLine();  // Consuma il newline dopo nextDouble()

                System.out.print("Digita il principio nutritivo del prodotto: ");
                String principio = scanner.nextLine();

                // Creazione del prodotto alimentare
                prodottoAlimentare prodottoAli = new prodottoAlimentare(codice, prezzo, principio, 2);
                negozio.addProdotto(prodottoAli);
                System.out.println("Prodotto alimentare aggiunto con successo.");
                break;

            default:
                System.out.println("Scelta non valida. Riprova.");
                break;
        }
    }
}
