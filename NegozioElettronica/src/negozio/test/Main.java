package negozio.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import negozio.Categoria;
import negozio.Negozio;
import negozio.Prodotto;
import negozio.ProdottoElettronico;

public class Main {

	public static void main(String[] args) {
		
		List<Categoria> listaCategoria = new ArrayList<Categoria>();
		listaCategoria.add(Categoria.ACCESSORIO);
		listaCategoria.add(Categoria.COMPUTER);
		listaCategoria.add(Categoria.SMARTPHONE);
		listaCategoria.add(Categoria.TV);
		Random rand = new Random();
		Negozio negozio=new Negozio();
		
		for(int i=1;i<=20;i++) {
			int randomDispo=rand.nextInt(2);
			int random=rand.nextInt(listaCategoria.size());
			if(randomDispo==0) {
				Prodotto prodotto = new Prodotto("Prodotto: "+i, 20+i, "Codice: "+i, i);
				negozio.aggiungiProdotto(prodotto);
			}else {
				ProdottoElettronico prodotto = new ProdottoElettronico("Prodotto: "+i, 20+i, "Codice: "+i, i, listaCategoria.get(random));
				negozio.aggiungiProdotto(prodotto);
			}
			
		}
		
		List<Prodotto> listaProdotti= negozio.getLista();
		listaProdotti=negozio.getProdottoOrdinatiPerNome();
		listaProdotti=negozio.getProdottoOrdinatiPerCategoria(Categoria.COMPUTER);
		listaProdotti=negozio.getProdottoOrdinatiPerPrezzo(40);
		System.out.println(negozio.rimuoviProdotto("Codice: "+13));
		listaProdotti=negozio.getProdottoOrdinatiPerPrezzo(40);
		if(listaProdotti.isEmpty()) {
			System.out.println("Nessun elemento presente");
		}else {
			listaProdotti.stream().forEach(l->System.out.println(l.toString()));
		}
		
	}

}
