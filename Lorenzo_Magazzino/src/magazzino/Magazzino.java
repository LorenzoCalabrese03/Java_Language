package magazzino;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Magazzino {
	List<Prodotto> listaProdotti=new ArrayList<Prodotto>();
	
	public boolean aggiungiProdotto( String codice, String nome, double prezzo, LocalDateTime dataScadenza, TipoProdotto tipo) {
		Prodotto prodotto=null;
		Random rand = new Random();
		List<TipoProdottoAlimentare> listaTipoProdotti = new ArrayList<TipoProdottoAlimentare>();
		listaTipoProdotti.add(TipoProdottoAlimentare.Fresco);
		listaTipoProdotti.add(TipoProdottoAlimentare.Secco);
		if(tipo==TipoProdotto.Alimentare) {
			int random = rand.nextInt(listaTipoProdotti.size());
				prodotto=new ProdottoAlimentare(nome, codice, prezzo, dataScadenza, tipo,listaTipoProdotti.get(random) );
				listaProdotti.add(prodotto);
		}else {
			int random=rand.nextInt(24);
			prodotto=new ProdottiElettrci(codice, nome, prezzo, dataScadenza, tipo, random);
			listaProdotti.add(prodotto);
		}
		return true;
	}
	
	public boolean rimuoviProdottoByCodice(String codice) {
		for(Prodotto entry: listaProdotti) {
			if(entry.getCodice().equals(codice)) {
				listaProdotti.remove(entry);
				return true;
			}
		}
		throw new Error("Prodotto non trovato");
	}
	public List<Prodotto> getProdottiOrdinatiPerDataScadenza(){
		List<Prodotto> listaOrdinata=new ArrayList<Prodotto>(listaProdotti);
		listaOrdinata.stream().sorted(Comparator.comparing(Prodotto::getDataScadenza));
		return listaOrdinata;
	}
	public List<Prodotto> getProdottiOrdinatiConPrezzoInferiore(double prezzo){
		List<Prodotto> listaOrdinata=new ArrayList<Prodotto>();
		for(Prodotto entry:listaProdotti) {
			if(entry.getPrezzo()<prezzo) {
				listaOrdinata.add(entry);
			}
		}
		return listaOrdinata;
	}
	public List<Prodotto> getProdottiOrdinatiPerTipo(TipoProdotto tipo){
		List<Prodotto> listaOrdinata=new ArrayList<Prodotto>();
		for(Prodotto entry:listaProdotti) {
			if(entry.getTipo().equals(tipo)) {
				listaOrdinata.add(entry);
			}
		}
		return listaOrdinata;
	}
}
