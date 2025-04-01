package bibliotecaMultimediale;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	List<ProdottoMultimediale> listaProdotti=new ArrayList<ProdottoMultimediale>();
	
	public boolean aggiungiProdotto(ProdottoMultimediale prodotto) {
		for(ProdottoMultimediale entry:listaProdotti) {
			if(entry.getTitolo().equals(prodotto.getTitolo())) {
				return false;
			}
		}
		listaProdotti.add(prodotto);
		return true;
	}
	
	public boolean rimuoviProdotto(String titolo) {
		for(ProdottoMultimediale entry:listaProdotti) {
			if(entry.getTitolo().equals(titolo)){
				listaProdotti.remove(entry);
				return true;
			}
		}
		return false;
	}
	public List<ProdottoMultimediale> cercaPerTitolo(String tiolo){
		List<ProdottoMultimediale> listaAggiornata = new ArrayList<ProdottoMultimediale>();
		listaProdotti.stream().forEach(l->{
			if(l.getTitolo().equalsIgnoreCase(tiolo)) {
				listaAggiornata.add(l);
			}
		});
		return listaAggiornata;
	}
	public List<ProdottoMultimediale> cercaPerAutore(String autore){
		List<ProdottoMultimediale> listaAggiornata = new ArrayList<ProdottoMultimediale>();
		listaProdotti.stream().forEach(l->{
			if(l.getAutore().equalsIgnoreCase(autore)) {
				listaAggiornata.add(l);
			}
		});
		return listaAggiornata;
	}
	public List<ProdottoMultimediale> cercaPerAnno(int anno){
		List<ProdottoMultimediale> listaAggiornata = new ArrayList<ProdottoMultimediale>();
		listaProdotti.stream().forEach(l->{
			if(l.getAnnoPubblicazione()==anno) {
				listaAggiornata.add(l);
			}
		});
		return listaAggiornata;
	}
	public List<ProdottoMultimediale> getLista(){
		return listaProdotti;
	}
}
