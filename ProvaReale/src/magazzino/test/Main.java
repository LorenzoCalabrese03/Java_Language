package magazzino.test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import magazzino.Categoria;
import magazzino.Magazzino;
import magazzino.Prodotto;
import magazzino.ProdottoAlimentare;
import magazzino.testDue.TestDue;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Random rand= new Random();
		Magazzino magazzino = new Magazzino();
		List<Prodotto> listaProdotti = new ArrayList<Prodotto>();
		List<Categoria> listaCategoria = new ArrayList<Categoria>();
		listaCategoria.add(Categoria.CONSERVA);
		listaCategoria.add(Categoria.FRESCO);
		listaCategoria.add(Categoria.SECCO);
		listaCategoria.add(Categoria.SURGELATO);
		for(int i=1;i<50;i++) {
			int random=rand.nextInt(2);
			if(random==0) {
				Prodotto prodotto = new Prodotto("Prodotto: "+i,"Codice: "+i , 10+i, LocalDateTime.now());
				magazzino.aggiungiProdotto(prodotto);
			}else {
				random=rand.nextInt(listaCategoria.size());
				Prodotto prodotto = new ProdottoAlimentare("Prodotto: "+i,"Codice: "+i , 10+i, LocalDateTime.now(), listaCategoria.get(random));
				magazzino.aggiungiProdotto(prodotto);
			}
		}
		
		//magazzino.getLista();
		//listaProdotti=magazzino.getProdottiOrdinatiPerNome();
		//listaProdotti=magazzino.getProdottiSopraPrezzo(20);
		//listaProdotti.stream().forEach(entry->System.out.println(entry.toString()));
		listaProdotti=magazzino.getProdottiPerCategoria(Categoria.CONSERVA);
		TestDue.salvataggioFile("/home/lorenzocalabrese/GitHub/Java_Language/ProvaReale/src/Salvataggio.txt", listaProdotti);
		System.out.println("Lettura File");
		TestDue.letturaFile("/home/lorenzocalabrese/GitHub/Java_Language/ProvaReale/src/Salvataggio.txt");
	}

}
