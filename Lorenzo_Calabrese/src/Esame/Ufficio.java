package Esame;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ufficio {
    private final int numero;
    private final String indirizzo;
    private final List<Sportello> sportelli;

    public Ufficio(int numero, String indirizzo, int numeroSportelli) {
        this.numero = numero;
        this.indirizzo = indirizzo;
        this.sportelli = new ArrayList<>();
        for (int i = 1; i <= numeroSportelli; i++) {
            sportelli.add(new Sportello(i));
        }
    }

    public Map<Integer, Integer> getNumeroPersonePerSportello() {
        Map<Integer, Integer> numeroPersoneMap = new HashMap<>();
        for (Sportello sportello : sportelli) {
            numeroPersoneMap.put(sportello.getNumero(), sportello.getNumeroPersone());
        }
        return numeroPersoneMap;
    }

    public boolean aggiungiPersona(Persona persona) {
        Sportello sportelloMin = sportelli.stream()
                .min(Comparator.comparingInt(Sportello::getNumeroPersone))
                .orElse(null);
        return sportelloMin != null && sportelloMin.aggiungiPersona(persona);
    }

    public Persona servirePersona() {
        return sportelli.stream()
                .filter(s -> !s.getPersone().isEmpty())
                .min(Comparator.comparingInt(s -> s.getPersone().stream().mapToInt(Persona::getId).min().orElse(Integer.MAX_VALUE)))
                .map(Sportello::servirePersona)
                .orElse(null);
    }

    public void stampaSportelli() {
        sportelli.stream()
                .sorted(Comparator.comparingInt(Sportello::getNumeroPersone))
                .forEach(s -> {
                    System.out.println("Sportello " + s.getNumero() + ":");
                    s.getPersone().stream()
                            .sorted(Comparator.comparing(Persona::getCognome))
                            .forEach(System.out::println);
                });
    }
 
}