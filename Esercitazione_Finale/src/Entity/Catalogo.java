package Entity;


import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * La classe Catalogo gestisce una collezione di abitazioni. Consente l'aggiunta,
 * la rimozione e la ricerca di abitazioni in base a diversi criteri.
 */
public class Catalogo {
    private TreeMap<String, Immobile> catalogoAbitazioni = new TreeMap<>();

    /**
     * Aggiunge un'abitazione al catalogo.
     *
     * @param abitazione l'abitazione da aggiungere al catalogo.
     * @return true se l'abitazione è stata aggiunta con successo.
     * @throws Errore se l'abitazione con lo stesso codice è già presente nel catalogo.
     */
    public boolean aggiungiAbitazione(Immobile abitazione) throws Errore {
        if (catalogoAbitazioni.containsKey(abitazione.getCodiceImmobile().toLowerCase())) {
            throw new Errore("Codice già presente");
        } else {
            catalogoAbitazioni.put(abitazione.getCodiceImmobile(), abitazione);
            return true;
        }
    }

    /**
     * Rimuove un'abitazione dal catalogo in base al codice specificato.
     *
     * @param codice il codice dell'abitazione da rimuovere.
     * @return true se l'abitazione è stata rimossa con successo.
     * @throws Errore se il codice dell'abitazione non è presente nel catalogo.
     */
    public boolean rimuoviAbitazioneByCodice(String codice) throws Errore {
        if (!catalogoAbitazioni.containsKey(codice.toLowerCase())) {
            throw new Errore("Elemento non presente");
        }
        catalogoAbitazioni.remove(codice);
        return true;
    }

    /**
     * Restituisce un elenco di abitazioni filtrato per il criterio specificato.
     *
     * @param filtro          il tipo di filtro da applicare: 1 per filtro sul costo,
     *                        2 per filtro sul luogo.
     * @param filtroParametro il parametro del filtro: deve essere un Double per il
     *                        filtro costo e una String per il filtro luogo.
     * @return una lista di abitazioni che soddisfano il criterio specificato.
     * @throws Errore se il tipo di filtro o il parametro del filtro non sono validi.
     */
    public List<Immobile> getElenco(int filtro, Object filtroParametro) throws Errore {
        switch (filtro) {
            case 1:
                if (!(filtroParametro instanceof Double)) {
                    throw new Errore("Parametro non valido per il filtro costo");
                }
                double costo = (Double) filtroParametro;
                return SearchByCosto(costo);

            case 2:
                if (!(filtroParametro instanceof String)) {
                    throw new Errore("Parametro non valido per il filtro luogo");
                }
                String luogo = (String) filtroParametro;
                return SearchByLuogo(luogo);

            default:
                throw new Errore("Scelta filtro non corretta");
        }
    }

    /**
     * Restituisce un elenco di abitazioni che hanno un costo superiore al valore
     * specificato.
     *
     * @param costo il costo minimo delle abitazioni da includere nell'elenco.
     * @return una lista di abitazioni con costo superiore al parametro specificato.
     */
    public List<Immobile> SearchByCosto(double costo) {
        return catalogoAbitazioni.values().stream()
                .filter(abitazione -> abitazione.getPrezzo() > costo)
                .sorted(Comparator.comparing(Immobile::calcolaPrezzo))
                .collect(Collectors.toList());
    }

    /**
     * Restituisce un elenco di abitazioni situate nel luogo specificato.
     *
     * @param luogo il luogo delle abitazioni da cercare.
     * @return una lista di abitazioni situate nel luogo specificato.
     */
    public List<Immobile> SearchByLuogo(String luogo) {
        return catalogoAbitazioni.values().stream()
                .filter(abitazione -> abitazione.getIndirizzo().equalsIgnoreCase(luogo))
                .collect(Collectors.toList());
    }

    /**
     * Restituisce l'abitazione con il costo massimo all'interno del catalogo.
     *
     * @return l'abitazione con il costo massimo, oppure null se il catalogo è vuoto.
     * @throws Errore se si verifica un errore durante la ricerca.
     */
    public Immobile AbitazioneCostosa() throws Errore {
        return catalogoAbitazioni.values().stream()
                .max(Comparator.comparing(Immobile::calcolaPrezzo))
                .orElse(null);
    }
}
