package biblioteca;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import java.util.Optional;

public class BibliotecaMultimediale {
 Map<String,ElementoMultimediale> listaElementi = new TreeMap<String,ElementoMultimediale>();
 
 public boolean aggiungiElemento(ElementoMultimediale elemento) {
	 listaElementi.put(elemento.getCodice(), elemento);
	 return true;
 }
 public boolean rimuoviElemento(String codice){
	if(listaElementi.containsKey(codice)) {
		listaElementi.remove(codice);
		return true;
	}
	return false;
 }
 
public List<ElementoMultimediale> filtra(TipoFileMultimediale tipo){
	List<ElementoMultimediale> listaFiltrata = new ArrayList<ElementoMultimediale>();
	listaElementi.entrySet().stream().forEach(entry -> {
		ElementoMultimediale elemento = entry.getValue();
		if(elemento.getTipo().equals(tipo)) {
			listaFiltrata.add(elemento);
		}
	});;
	
	return listaFiltrata;
}
	public Optional<ElementoMultimediale> getElementoDurataMaggiore() {
		
		return listaElementi.values().stream().max(Comparator.comparing(ElementoMultimediale::getDurata));
		
	}
	public Map<String,ElementoMultimediale> getLista(){
		return listaElementi;
	}
}
