package esonero2.catalogo;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * La classe Catalogo gestisce un insieme di oggetti Abitazioni, offrendo metodi
 * per aggiungere, rimuovere, filtrare e visualizzare le abitazioni in base a criteri specifici.
 */
public class Catalogo {

    private TreeMap<String, Abitazioni> Catalogo = new TreeMap<>();
    /**
     * Aggiunge un'abitazione al catalogo. 
     * Se una abitazione con lo stesso codice esiste già, viene lanciata un'eccezione.
     *
     * @param abitazione l'abitazione da aggiungere al catalogo
     * @return true se l'abitazione è stata aggiunta con successo, false altrimenti
     * @throws Errore se il codice dell'abitazione è già presente nel catalogo
     */
    public boolean aggiungiAlCatalogo(Abitazioni abitazione) throws Errore {
        if (Catalogo.containsKey(abitazione.getCodice())) {
            throw new Errore("\nIl codice è già presente\n");
        } else {
            Catalogo.put(abitazione.getCodice(), abitazione);
            return true;
        }
    }
    /**
     * Rimuove un'abitazione dal catalogo in base al codice.
     *
     * @param codice il codice dell'abitazione da rimuovere
     * @return true se l'abitazione è stata rimossa, false altrimenti
     * @throws Errore se il codice specificato non è presente nel catalogo
     */
    public boolean rimuoviAbitazioneByCodice(String codice) throws Errore {
    	boolean fleg=false;
    	if(Catalogo.containsKey(codice)) {
    		Catalogo.remove(codice);
    		fleg=true;
    	}else {
    		throw new Errore("Il codice non è presente in elenco");
    	}
        return fleg;
    }
    /**
     * Ottiene un elenco filtrato delle abitazioni in base al filtro specificato.
     * Il filtro può essere per prezzo minimo o per luogo specifico.
     *
     * @param Filtro il tipo di filtro (1 per prezzo, 2 per luogo)
     * @return un set di abitazioni filtrato in base al criterio scelto
     * @throws Errore se il filtro non è valido o se non ci sono abitazioni che corrispondono al filtro
     */
    public Set<Abitazioni> getElenco(int Filtro) throws Errore {
        Set<Abitazioni> Elenco;
        try (Scanner scanner = new Scanner(System.in)) {
            switch (Filtro) {
                case 1 -> {
                    System.out.println("Seleziona prezzo: ");
                    double prezzo = scanner.nextDouble();
                    scanner.nextLine(); // Consuma il newline lasciato da nextDouble
                    Elenco = filtroByCosto(Catalogo, prezzo);
                    descrizione(Elenco);
                }
                case 2 -> {
                    System.out.println("Seleziona il luogo: ");
                    
                    String luogo = scanner.nextLine().trim();
                    Elenco = filtroByLuogo(Catalogo, luogo.toLowerCase());
                    descrizione(Elenco);
                }
                default -> throw new Errore("Errore nella selezione");
            }
        }
        return Elenco;
    }
    /**
     * Filtra le abitazioni in base a un prezzo minimo.
     *
     * @param Catalogo il catalogo di abitazioni da cui filtrare
     * @param prezzo il prezzo minimo per filtrare le abitazioni
     * @return un set di abitazioni con prezzo superiore o uguale al valore specificato
     * @throws Errore se nessuna abitazione soddisfa il criterio di prezzo
     */
    private static Set<Abitazioni> filtroByCosto(TreeMap<String, Abitazioni> Catalogo, double prezzo) throws Errore {
        Set<Abitazioni> abitazioni = Catalogo.values().stream()
            .filter(abitazione -> abitazione.getPrezzo() >= prezzo)
            .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparingDouble(Abitazioni::getPrezzo))));

        if (abitazioni.isEmpty()) {
            throw new Errore("Nessuna abitazione trovata con prezzo superiore a " + prezzo);
        }
//		TreeSet<Abitazioni> abitazioniFiltrati = new TreeSet<Abitazioni>((Abitazioni p1, Abitazioni p2)->{
//		int comparatorePrezzo = Double.compare(p1.getPrezzo(), p2.getPrezzo());
//		if(comparatorePrezzo != 0) {
//			return comparatorePrezzo;
//		}else {
//			return p1.getCodice().compareTo(p2.getCodice());
//		}
//		
//		});
//	 abitazioniFiltrati.addAll(Catalogo.values());
        return abitazioni;
    }
    /**
     * Filtra le abitazioni in base al luogo specificato.
     *
     * @param Catalogo il catalogo di abitazioni da cui filtrare
     * @param luogo il luogo per filtrare le abitazioni
     * @return un set di abitazioni situate nel luogo specificato
     * @throws Errore se nessuna abitazione si trova nel luogo specificato
     */
    private static Set<Abitazioni> filtroByLuogo(TreeMap<String, Abitazioni> Catalogo, String luogo) throws Errore {
        Set<Abitazioni> abitazioni = Catalogo.values().stream()
            .filter(abitazione -> abitazione.getLuogo().toLowerCase().equals(luogo))
            .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Abitazioni::getCodice))));

        if (abitazioni.isEmpty()) {
            throw new Errore("Luogo non presente in elenco");
        }
//		
//		TreeSet<Abitazioni> abitazioniFiltrati = new TreeSet<Abitazioni>();
//		for(Abitazioni entry:Catalogo.values()) {
//			if(entry.getLuogo().equals(luogo)) {
//				abitazioniFiltrati.add(entry);
//				fleg=true;
//			}
//		}
//		if(fleg==false) {
//			throw new Errore("Luogo non prensete in elenco");
//		}
        return abitazioni;
    }
    /**
     * Stampa la descrizione di ogni abitazione presente nel catalogo filtrato.
     *
     * @param catalogo il set di abitazioni da descrivere
     */

    public void descrizione(Set<Abitazioni> catalogo) {
        catalogo.forEach(abitazione -> System.out.println(abitazione.descrizione()));
    }
}

