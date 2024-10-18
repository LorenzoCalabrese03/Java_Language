package Entity.test;

import java.util.ArrayList;

/**
 * La classe Negozio rappresenta un negozio che gestisce una lista di prodotti e fatture.
 * Offre metodi per aggiungere prodotti e fatture, calcolare i pagamenti totali, e ottenere informazioni sui prodotti.
 */
public class Negozio {

    /**
     * Lista delle fatture associate al negozio.
     */
    private ArrayList<Fattura> ListaFatture = new ArrayList<>();

    /**
     * Lista dei prodotti disponibili nel negozio.
     */
    private ArrayList<Prodotto> ListaProdotti = new ArrayList<>();

    /**
     * Aggiunge un prodotto alla lista dei prodotti se non è già presente.
     * 
     * @param prodotto Il prodotto da aggiungere.
     */
    public void addProdotto(Prodotto prodotto) {
        if (!ListaProdotti.contains(prodotto)) {
            ListaProdotti.add(prodotto);
        }
    }

    /**
     * Aggiunge una fattura alla lista delle fatture se non è già presente.
     * 
     * @param fattura La fattura da aggiungere.
     */
    public void addFattura(Fattura fattura) {
        if (!ListaFatture.contains(fattura)) {
            ListaFatture.add(fattura);
        }
    }

    /**
     * Restituisce una lista contenente tutti i pagamenti associati ai prodotti.
     * 
     * @return Un'ArrayList di oggetti Pagamento con tutti i pagamenti relativi ai prodotti.
     */
    public ArrayList<Pagamento> getAllPagamenti() {
        ArrayList<Pagamento> pagamenti = new ArrayList<>();
        pagamenti.addAll(ListaProdotti);
        // pagamenti.addAll(ListaFatture);
        return pagamenti;
    }

    /**
     * Calcola la quantità di prodotti di una specifica categoria.
     * 
     * @param prodotto Il tipo di prodotto (1 per elettronici, 2 per alimentari).
     * @return Il numero di prodotti appartenenti alla categoria specificata.
     */
    public int calcoloQuantità(int prodotto) {
        int counter = 0;
        switch (prodotto) {
            case 1:
                for (Prodotto entry : ListaProdotti) {
                    if (entry instanceof prodottiElettronici) {
                        counter++;
                    }
                }
                break;
            case 2:
                for (Prodotto entry : ListaProdotti) {
                    if (entry instanceof prodottoAlimentare) {
                        counter++;
                    }
                }
                break;
        }
        return counter;
    }

    /**
     * Calcola il costo totale dei prodotti di una specifica categoria.
     * 
     * @param prodotto Il tipo di prodotto (1 per elettronici, 2 per alimentari).
     * @return Il costo totale dei prodotti della categoria specificata.
     */
    public double calcoloImportoUni(int prodotto) {
        double totale = 0;
        switch (prodotto) {
            case 1:
                for (Prodotto entry : ListaProdotti) {
                    if (entry instanceof prodottiElettronici) {
                        prodottiElettronici prod = (prodottiElettronici) entry;
                        totale += prod.calcolaCosto();
                    }
                }
                break;
            case 2:
                for (Prodotto entry : ListaProdotti) {
                    if (entry instanceof prodottoAlimentare) {
                        prodottoAlimentare prod = (prodottoAlimentare) entry;
                        totale += prod.calcolaCosto();
                    }
                }
                break;
        }
        return totale;
    }
}
