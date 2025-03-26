package dizionario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Dizionario {
	List<Coppia> listaCoppie = new ArrayList<Coppia>();
	Map<Object,Object> mappa = new HashMap<Object,Object>();
	
	public void aggiuntaCoppia(Object key,Object value) {
		mappa.put(key, value);
	}
	
	public void rimuoviCoppia(Object key) {
		if(mappa.containsKey(key)) {
			mappa.remove(key);
			System.out.println("Successo");
		}
	}
	
	public Object searchCoppiaByKey(Object key) {
		Object oggetto=mappa.get(key);
		return oggetto;
	}
	
	public void searchByName(String nome) {
		if(mappa.entrySet().stream().anyMatch(entry -> entry.getKey().equals(nome)) ) {
			System.out.println("Successo");
		}else {
			System.out.println("In successo");
		}
		
	}
	public void stampaMappa() {
	mappa.entrySet().stream().forEach(entry -> System.out.println(entry.getKey()+" "+entry.getValue() ));
	}
	
	public void stampaLista() {
		listaCoppie.stream().forEach(entry -> System.out.println(entry.toString()));
		}
	
	public void trasformazioneInLista() {
		mappa.entrySet().stream().forEach(entry -> {Object key=entry.getKey();
		Object value=entry.getValue(); 
		Coppia coppia = new Coppia(key,value);
		listaCoppie.add(coppia);
		});

	}
	
}
