package Entity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * La classe Magazzino rappresenta un magazzino che gestisce un insieme di prodotti.
 * Permette di aggiungere, rimuovere e cercare prodotti in base a vari criteri come costo e nome.
 */
public class Magazzino {
    HashMap<Integer,Prodotto> ListaProdotti = new HashMap<Integer,Prodotto>();

    /**
     * Aggiunge un prodotto al magazzino.
     * 
     * @param prodotto Il prodotto da aggiungere.
     * @return true se il prodotto è stato aggiunto con successo, false altrimenti.
     * @throws ProdottoExeption se il prodotto è già presente nel magazzino.
     */
    public boolean aggiungiProdotto(Prodotto prodotto) throws ProdottoExeption {
        if(ListaProdotti.containsKey(prodotto.getCodice())) {
            throw new ProdottoExeption("Elemento già presente:\n");
        } else {
            ListaProdotti.put(prodotto.getCodice(),prodotto);
            return true;
        }
    }

    /**
     * Rimuove tutti i prodotti con un costo inferiore o uguale al valore specificato.
     * 
     * @param costo Il costo massimo dei prodotti da rimuovere.
     * @return true se almeno un prodotto è stato rimosso, false altrimenti.
     */
    public boolean cancellaProdottiByCosto(double costo) {
        boolean flag = false;
        Iterator<Map.Entry<Integer, Prodotto>> iterator = ListaProdotti.entrySet().iterator();
        
        while (iterator.hasNext()) {
            Map.Entry<Integer, Prodotto> entry = iterator.next();
            Prodotto prodotto = entry.getValue();
            
            if (prodotto.getCosto() <= costo) {
                iterator.remove(); // Rimuove in modo sicuro l'elemento corrente
                flag = true;
            }
        }
        
        return flag;
    }

    /**
     * Visualizza tutti i prodotti con un costo superiore o uguale al valore specificato.
     * 
     * @param costo Il costo minimo dei prodotti da visualizzare.
     * @throws ProdottoExeption se nessun prodotto è trovato.
     */
    public void getProdottiCostoSuperiore(double costo) throws ProdottoExeption {
        for(Map.Entry<Integer, Prodotto> entry : ListaProdotti.entrySet()) {
            Prodotto prodotto = entry.getValue();
            if(prodotto.getCosto() >= costo) {
                System.out.println(prodotto.descrizione());
            }
        }
    }

    /**
     * Cerca e visualizza un prodotto in base al suo codice.
     * 
     * @param codiceProdotto Il codice del prodotto da cercare.
     * @throws ProdottoExeption se il prodotto non viene trovato.
     */
    public void searchByCodice(Integer codiceProdotto) throws ProdottoExeption {
        if(ListaProdotti.containsKey(codiceProdotto)) {
            Prodotto prodotto = ListaProdotti.get(codiceProdotto);
            System.out.println(prodotto.descrizione());
        } else {
            throw new ProdottoExeption("Prodotto non trovato");
        }
    }

    /**
     * Cerca e visualizza tutti i prodotti con il nome specificato.
     * 
     * @param nomeProdotto Il nome del prodotto da cercare.
     * @throws ProdottoExeption se nessun prodotto viene trovato con il nome specificato.
     */
    public void getProdottiByNome(String nomeProdotto) throws ProdottoExeption {
        boolean flag = false;
        for (Map.Entry<Integer, Prodotto> entry : ListaProdotti.entrySet()) {
            Prodotto prodotto = entry.getValue();
            
            if (prodotto.getNome() != null && prodotto.getNome().toLowerCase().equals(nomeProdotto.toLowerCase())) {
                System.out.println(prodotto.descrizione());
                flag = true;
            }
        }
        if (!flag) {
            throw new ProdottoExeption("Prodotto non trovato");
        }
    }

    /**
     * Cerca e visualizza tutti i prodotti con il nome specificato, ordinati per costo decrescente.
     * 
     * @param nomeProdotto Il nome del prodotto da cercare.
     * @throws ProdottoExeption se nessun prodotto viene trovato con il nome specificato.
     */
    public void getProdottiByNomeOrdinatiPerCosto(String nomeProdotto) throws ProdottoExeption {
        boolean flag = false;
        List<Prodotto> prodottiFiltrati = new ArrayList<>();
        
        for (Map.Entry<Integer, Prodotto> entry : ListaProdotti.entrySet()) {
            Prodotto prodotto = entry.getValue();
            if (prodotto.getNome() != null && prodotto.getNome().toLowerCase().equals(nomeProdotto.toLowerCase())) {
                prodottiFiltrati.add(prodotto);
                flag = true;
            }
        }
        
        if (flag) {
            // Ordinamento per costo decrescente
            prodottiFiltrati.sort(Comparator.comparing(Prodotto::getCosto).reversed());
            for(Prodotto entry : prodottiFiltrati) {
                System.out.println(entry.descrizione());
            }
        } else {
            throw new ProdottoExeption("Prodotti non trovati");
        }
    }
}
