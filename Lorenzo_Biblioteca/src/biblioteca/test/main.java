package biblioteca.test;

import java.util.ArrayList;
import java.util.List;

import biblioteca.Biblioteca;
import biblioteca.Categoria;
import biblioteca.Libro;
import biblioteca.Prestito;
import biblioteca.Utente;

public class main {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Libro romanzo=new Libro(2, "Romanzo", "Io", true);
		Libro fantasy=new Libro(3, "Fantasy", "Io", true);
		Biblioteca Bari=new Biblioteca();
		Utente Lorenzo=new Utente("Lorenzo", "Calabrese",Categoria.Studente);
		Utente Andrea=new Utente("Andrea", "Roma",Categoria.Studente);
		System.out.println(Lorenzo.toString());
		System.out.println(Andrea.toString());
		System.out.println(Bari.aggiungiUtente(Lorenzo));
		System.out.println(Bari.aggiungiUtente(Andrea));
		System.out.println(Bari.aggiungiLibro(romanzo));
		System.out.println(Bari.aggiungiLibro(fantasy));
		List<Libro>libri=new ArrayList<Libro>();
		libri=Bari.listaLirbi();
		for(Libro entry:libri) {
			System.out.println(entry.toString());
		}
		System.out.println(Bari.prestito(Lorenzo, romanzo, 5));
		System.out.println(Bari.prestito(Andrea, fantasy, 4));
		libri=Bari.listaLirbi();
		for(Libro entry:libri) {
			System.out.println(entry.toString());
		}
		List<Prestito>prestiti=new ArrayList<Prestito>(Bari.listaPrestiti());
		for(Prestito entry:prestiti) {
			System.out.println(entry.toString());
		}
		prestiti= (Bari.prestitiOrdinati());
		for(Prestito entry:prestiti) {
			System.out.println(entry.toString());
		}
		System.out.println(Bari.restituzione(2));
		prestiti= (Bari.prestitiOrdinati());
	for(Prestito entry:prestiti) {
		System.out.println(entry.toString());
	}
	}
	
}
