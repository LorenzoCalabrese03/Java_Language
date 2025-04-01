package negozio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Negozio {
	List<Prodotto> listaProdotti = new ArrayList<Prodotto>();
	
	public boolean aggiungiProdotto(Prodotto prodotto) {
		listaProdotti.stream().forEach(l->{
			if(l.getCodice().equals(prodotto.getCodice())){
				throw new Error("Prodotto già presente");
			}
		});
		listaProdotti.add(prodotto);
		return true ;
	}
	
	public boolean rimuoviProdotto(String codice) {
		for(Prodotto entry:listaProdotti) {
			if(entry.getCodice().equals(codice)) {
				listaProdotti.remove(entry);
				return true;
			}
		}
		return false;
	}
	public List<Prodotto> getProdottoOrdinatiPerNome(){
		List<Prodotto> listaOrdinata = new ArrayList<Prodotto>(listaProdotti);
		return listaOrdinata.stream().sorted(Comparator.comparing(Prodotto::getNome).reversed()).collect(Collectors.toList());
	}
	
	public List<Prodotto> getProdottoOrdinatiPerPrezzo(double prezzo){
		List<Prodotto> listaOrdinata = new ArrayList<Prodotto>(listaProdotti);
		return listaOrdinata.stream().filter(l->l.getPrezzo()<prezzo).collect(Collectors.toList());
	}
	
	public List<Prodotto> getProdottoOrdinatiPerCategoria(Categoria categoria){
		List<Prodotto> listaOrdinata = new ArrayList<Prodotto>();
		listaProdotti.stream().forEach(l->{
			if(l instanceof ProdottoElettronico) {
				ProdottoElettronico prodotto = (ProdottoElettronico) l;
				if(prodotto.getCategoria().equals(categoria)) {
					listaOrdinata.add(prodotto);
				}
			}
		});
		return listaOrdinata;
		}
	public List<Prodotto> getLista(){
		return listaProdotti;
	}
	}

