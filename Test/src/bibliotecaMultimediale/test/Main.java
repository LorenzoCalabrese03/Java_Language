package bibliotecaMultimediale.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import bibliotecaMultimediale.AudioLibro;
import bibliotecaMultimediale.Biblioteca;
import bibliotecaMultimediale.Bibliotecario;
import bibliotecaMultimediale.EBook;
import bibliotecaMultimediale.Formato;
import bibliotecaMultimediale.Libro;
import bibliotecaMultimediale.ProdottoMultimediale;
import bibliotecaMultimediale.Rivista;
import bibliotecaMultimediale.test.due.TestDue;

public class Main {

	public static void main(String[] args) throws IOException {
		List<ProdottoMultimediale> listaProdotti = new ArrayList<ProdottoMultimediale>();
		Biblioteca biblioteca = new Biblioteca();
		Bibliotecario Lorenzo = new Bibliotecario("Lorenzo","Calabrese");
		List<Formato> listaFormati = new ArrayList<Formato>();
		listaFormati.add(Formato.ePub);
		listaFormati.add(Formato.Mobi);
		listaFormati.add(Formato.PDF);
		
		Random rand = new Random();
		int j=0;
		for(int i=0;i<20;i++) {
			int random=rand.nextInt(4);
			ProdottoMultimediale prodotto=null;
			switch(random) {
			case 0:
				prodotto=new Libro("Titolo: "+i, "Autore: "+i, "12"+i, i);
				Lorenzo.aggiungiProdottoAllaBiblioteca(biblioteca, prodotto);
			case 1:
				j++;
				prodotto=new Rivista("Titolo: "+i, "Autore: "+i,i,i-j);
				Lorenzo.aggiungiProdottoAllaBiblioteca(biblioteca, prodotto);
			case 2:
				int randomFormato=rand.nextInt(listaFormati.size());
				prodotto=new EBook("Titolo: "+i, "Autore: "+i, i, listaFormati.get(randomFormato));
				Lorenzo.aggiungiProdottoAllaBiblioteca(biblioteca, prodotto);
			case 3:
				prodotto=new AudioLibro("Titolo: "+i, "Autore: "+i, i,i);
				Lorenzo.aggiungiProdottoAllaBiblioteca(biblioteca, prodotto);
			}
		}
		listaProdotti=biblioteca.getLista();
		//listaProdotti=biblioteca.cercaPerAnno(10);
		//listaProdotti=biblioteca.cercaPerAutore("autore: "+12);
		//listaProdotti=biblioteca.cercaPerTitolo("Titolo: "+2);
		
		listaProdotti.stream().forEach(l->System.out.println(l.toString()));
		
		TestDue.salvataggio(listaProdotti, "/home/lorenzocalabrese/GitHub/Java_Language/Test/src/Libir.txt");
	}

}
