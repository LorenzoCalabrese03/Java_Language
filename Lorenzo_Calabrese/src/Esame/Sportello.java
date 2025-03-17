package Esame;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Sportello {
    private final int numero;
    private final Map<Integer, Persona> persone;

    public Sportello(int numero) {
        this.numero = numero;
        this.persone = new HashMap<>();
    }

    public int getNumero() {
        return numero;
    }

    public Collection<Persona> getPersone() {
        return persone.values();
    }

    public int getNumeroPersone() {
        return persone.size();
    }

    public boolean aggiungiPersona(Persona persona) {
        if (persone.size() < 20) {
            persone.put(persona.getId(), persona);
            return true;
        }
        return false;
    }

    public Persona servirePersona() {
        if (persone.isEmpty()) return null;
        // Trovare la persona con ID minimo
        int idMin = Collections.min(persone.keySet());
        return persone.remove(idMin);
    }

    public boolean rimuoviPersona(int id) {
        return persone.remove(id) != null;
    }
}