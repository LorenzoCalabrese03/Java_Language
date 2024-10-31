package Esonero.store;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class MagazzinoProdotti {
    private TreeMap<String, Prodotto> CollezioneProdotti = new TreeMap<>();

    /**
     * Aggiunge un prodotto alla collezione.
     *
     * @param prodotto il prodotto da aggiungere
     * @return true se il prodotto è stato aggiunto, false altrimenti
     * @throws Errore se il codice del prodotto è già presente
     */
    public boolean aggiungiProdotti(Prodotto prodotto) throws Errore {
        if (CollezioneProdotti.containsKey(prodotto.getCodice())) {
            throw new Errore("Codice già presente");
        } else {
            CollezioneProdotti.put(prodotto.getCodice(), prodotto);
            return true;
        }
    }

    /**
     * Rimuove un prodotto dalla collezione per codice.
     *
     * @param codice il codice del prodotto da rimuovere
     * @return true se il prodotto è stato rimosso, false altrimenti
     * @throws Errore se il codice è nullo o vuoto
     */
    public boolean rimuoviProdotto(String codice) throws Errore {
        if (codice == null || codice.isEmpty()) {
            throw new Errore("Codice non inserito");
        }
        return CollezioneProdotti.remove(codice) != null;
    }

    /**
     * Ottiene una lista filtrata di prodotti in base al filtro specificato.
     *
     * @param filtro il tipo di filtro (1 per prezzo, 2 per carattere nel nome)
     * @return un set di prodotti filtrato
     * @throws Errore se il filtro non è valido
     */
    public Set<Prodotto> getLista(int filtro) throws Errore {
        Set<Prodotto> ListaProdotti = new TreeSet<>(Comparator.comparing(Prodotto::getPrezzo));
        try (Scanner scanner = new Scanner(System.in)) {
            switch (filtro) {
                case 1:
                    System.out.println("Inserisci il prezzo: ");
                    double prezzo = scanner.nextDouble();
                    ListaProdotti = FiltroPrezzoCosto(prezzo);
                    descrizione(ListaProdotti);
                    break;
                case 2:
                    System.out.println("Scegli il carattere: ");
                    char carattere = scanner.next().charAt(0);
                    ListaProdotti = ProdottiConCarattere(carattere);
                    descrizione(ListaProdotti);
                    break;
                default:
                    throw new Errore("Scelta non valida");
            }
        }
        return ListaProdotti;
    }

    /**
     * Filtra i prodotti in base al prezzo, in ordine decrescente.
     *
     * @param Prodotti la collezione di prodotti
     * @return un set di prodotti ordinato per prezzo decrescente
     */
    public Set<Prodotto> FiltroPrezzi() {
        return CollezioneProdotti.values().stream()
            .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Prodotto::getPrezzo).reversed())));
    }

    /**
     * Filtra i prodotti con prezzo maggiore o uguale a un valore specifico.
     *
     * @param Prodotti la collezione di prodotti
     * @param prezzo il prezzo minimo per il filtro
     * @return un set di prodotti con prezzo maggiore o uguale al valore specificato
     */
    public Set<Prodotto> FiltroPrezzoCosto(double prezzo) {
        return CollezioneProdotti.values().stream()
            .filter(prodotto -> prodotto.getPrezzo() >= prezzo)
            .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Prodotto::getPrezzo))));
    }

    /**
     * Trova il prodotto con il prezzo più alto.
     *
     * @param Prodotti la collezione di prodotti
     * @return il prodotto con il prezzo più alto, o null se non ci sono prodotti
     */
    public Prodotto ProdottoPrezzoAlto() {
        return CollezioneProdotti.values().stream()
            .max(Comparator.comparingDouble(Prodotto::getPrezzo))
            .orElse(null);
    }

    /**
     * Filtra i prodotti che contengono un carattere specifico nel nome.
     *
     * @param Prodotti la collezione di prodotti
     * @param carattere il carattere da cercare nel nome dei prodotti
     * @return un set di prodotti che contengono il carattere specificato
     */
    public Set<Prodotto> ProdottiConCarattere( char carattere) {
        return CollezioneProdotti.values().stream()
            .filter(prodotto -> java.util.Arrays.stream(prodotto.getNome().toLowerCase().split(""))
                .anyMatch(c -> c.equals(String.valueOf(carattere)))) // Confronta i caratteri come stringhe
            .collect(Collectors.toSet());
    }

    /**
     * Stampa la descrizione di ciascun prodotto nella collezione.
     *
     * @param catalogo il set di prodotti da descrivere
     */
    public void descrizione(Set<Prodotto> catalogo) {
        catalogo.forEach(prodotto -> System.out.println(prodotto.descrizione()));
    }
}
