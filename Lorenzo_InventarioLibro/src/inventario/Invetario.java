package inventario;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Invetario {
	Map<Libro,Integer> invetario= new HashMap<Libro,Integer>();
	
	public boolean aggiuntaLibro(String titolo, int numero) {
	    // Controllo se il libro è già presente nel inventario
	    Libro libro = invetario.keySet().stream()
	                            .filter(l -> l.getTitolo().equals(titolo))
	                            .findFirst()
	                            .orElse(null);
	    
	    if (libro != null) {
	        // Se il libro è già presente, aggiorno la quantità
	        int num = invetario.get(libro) + numero;
	        invetario.put(libro, num);
	    } else {
	        // Se il libro non è presente, aggiungo un nuovo libro
	        Libro nuovoLibro = new Libro(titolo); // Assicurati che il costruttore di Libro prenda il titolo
	        invetario.put(nuovoLibro, numero);
	    }

	    ordinamento(); // Ordino l'inventario
	    return true;
	}

	
	public boolean removeLibro(String titolo) {
		Libro libro=invetario.keySet().stream().filter(l->l.getTitolo().equals(titolo)).findFirst().orElse(null);
		if(libro==null) {
			return false;
		}else {
			invetario.remove(libro);
			return true;
		}
		
	
	}
	
	public String serechByTitle(String titolo) {
		Libro libro=invetario.keySet().stream().filter(l->l.getTitolo().equals(titolo)).findFirst().orElse(null);
		return libro.toString();
		
	}
	
	public void Stampa() {
		invetario.entrySet().stream().forEach(entry->System.out.println(entry.getKey().toString()+" "+entry.getValue()));
	}
	
	private void ordinamento() {
		invetario.entrySet().stream().sorted(Comparator.comparing(entry -> entry.getKey().getTitolo())); // Ordina per titolo del libro
	}
	public Map<Libro,Integer> getMappa(){
		return invetario;
	}
}
