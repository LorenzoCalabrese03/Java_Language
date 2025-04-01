package magazzino;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Magazzino {
	List<Prodotto> listaProdotti = new ArrayList<Prodotto>();
	
	
	public boolean aggiungiProdotto(Prodotto prodotto) {
		listaProdotti.add(prodotto);
		return true;
	}
	public boolean aggiungiProdotto(ProdottoAlimentare prodotto) {
		listaProdotti.add(prodotto);
		return true;
	}
	
	public boolean rimuoviProdotto(String codice) {
		 listaProdotti.stream().forEach(entry->{
			if(entry.getCodice().equals(codice)) {
				listaProdotti.remove(entry);	
			}
		});
		 return false;
	}
	
	public List<Prodotto> getProdottiOrdinatiPerNome(){
		List<Prodotto> listaOrdinata=new ArrayList<Prodotto>(listaProdotti);
		return listaOrdinata.stream().sorted(Comparator.comparing(Prodotto::getNome)).collect(Collectors.toList());
	
		
	}
	
	public List<Prodotto> getProdottiSopraPrezzo(double prezzo){
		List<Prodotto> listaOrdinata=new ArrayList<Prodotto>(listaProdotti);
		return listaOrdinata.stream().filter(l->l.getPrezzo()>=prezzo).collect(Collectors.toList());
		
	}
	public void getLista() {
		listaProdotti.stream().forEach(entry->System.out.println(entry.toString()));
	}
	public List<Prodotto> getProdottiPerCategoria(Categoria categoria){
		List<Prodotto> listaOrdinata=new ArrayList<Prodotto>();
		for(Prodotto entry:listaProdotti) {
			if(entry instanceof ProdottoAlimentare) {
				ProdottoAlimentare prodotto = (ProdottoAlimentare) entry;
				
				if(prodotto.getCategoria().equals(categoria)) {
					listaOrdinata.add(prodotto);
					
				}
				
			}
		}
		return listaOrdinata;
	}
}
