package biblioteca;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {
	List<Pubblicazione> listaPubblicazioni = new ArrayList<Pubblicazione>();
	
	public boolean aggiungiPubblicazione(Pubblicazione pubblicazione) {
		listaPubblicazioni.add(pubblicazione);
		return true;
	}
	
	public List<Pubblicazione> getPubblicazionePerDataPubblicazione(){
		List<Pubblicazione> listaOrdinata = new ArrayList<Pubblicazione>(listaPubblicazioni);
		listaOrdinata.stream().sorted(Comparator.comparing(Pubblicazione::getData)).collect(Collectors.toList());
		return listaOrdinata;
	}
	
	public List<Pubblicazione> getPubblicazioneConPrezzoInferiore(double prezzo){
		List<Pubblicazione> listaOrdinata = new ArrayList<Pubblicazione>();
		for(Pubblicazione entry:listaPubblicazioni) {
			if(entry.calcoloSconto()<prezzo) {
				listaOrdinata.add(entry);
			}
		}
		return listaOrdinata;
	}
	
	
}
