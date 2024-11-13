package File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.List;

import Entity.Immobile;

public class Serializzazione {
//IMPORTANTE
    //DEVI METTERE AD OGNI CLASSE CHE SALVI implements Serializable ALTRIMENTI NON TE LO SALVA NEI FILE
    //es public static void Immobile implements Serializable{ 
    //  }
//IMPORTANTE
    /**
     * Carica una lista di oggetti Abitazione da un file binario tramite deserializzazione.
     *
     * @param fileName il nome del file binario da cui caricare i dati.
     * @return la lista di abitazioni deserializzate dal file.
     */
    @SuppressWarnings("unchecked")
    public static List<Immobile> caricaAbitazioniSerializzate(String fileName) {
        List<Immobile> listaAbitazioni = null;
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            listaAbitazioni = (List<Immobile>) ois.readObject();
            System.out.println("Abitazioni caricate correttamente da " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Errore durante la deserializzazione: " + e.getMessage());
        }

        return listaAbitazioni;
    }
    /**
     * Salva una lista di oggetti Abitazione in un file binario tramite serializzazione.
     *
     * @param listaAbitazioni la lista di abitazioni da serializzare e salvare.
     * @param fileName        il nome del file binario in cui salvare i dati.
     */
    public static void salvaAbitazioniSerializzate(List<Immobile> listaAbitazioni, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(listaAbitazioni);
            System.out.println("Abitazioni salvate correttamente in formato serializzato su " + fileName);
        } catch (IOException e) {
            System.out.println("Errore durante la serializzazione: " + e.getMessage());
        }
    }
}
