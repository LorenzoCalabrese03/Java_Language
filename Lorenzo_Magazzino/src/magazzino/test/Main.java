package magazzino.test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import magazzino.Magazzino;
import magazzino.Prodotto;
import magazzino.TipoProdotto;
import magazzino.test.due.TestDue;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		List<Prodotto> listaProdotti = new ArrayList<Prodotto>();
		List<TipoProdotto> tipoProdotto = new ArrayList<TipoProdotto>();
		tipoProdotto.add(TipoProdotto.Alimentare);
		tipoProdotto.add(TipoProdotto.Elettronico);
		Magazzino magazzino = new Magazzino();
		Random rand= new Random();
		for(int i=1;i<=20;i++) {
			LocalDateTime date=LocalDateTime.now();
			//DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
			int random = rand.nextInt(tipoProdotto.size());
			magazzino.aggiungiProdotto("Codice:"+i, "Nome: "+i, i,date , tipoProdotto.get(random));
		}
		
		listaProdotti=magazzino.getProdottiOrdinatiPerDataScadenza();
		listaProdotti=magazzino.getProdottiOrdinatiPerTipo(TipoProdotto.Alimentare);
		listaProdotti=magazzino.getProdottiOrdinatiConPrezzoInferiore(10);
		for(Prodotto entry:listaProdotti) {
			System.out.println(entry.toString());
		}
		
		TestDue.salvataggioProdotti(listaProdotti, "/home/lorenzocalabrese/GitHub/Java_Language/Lorenzo_Magazzino/src/magazzino.txt");
		TestDue.letturaFile("/home/lorenzocalabrese/GitHub/Java_Language/Lorenzo_Magazzino/src/magazzino.txt");
	}

}
