package libro.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import libro.Autore;
import libro.Libro;

public class Libreria {
	public static void main(String[] args) {
		List<Autore> listaAutori=new ArrayList<Autore>();
		List<Libro> listaLibri=new ArrayList<Libro>();
		Random rand=new Random();
		Libro libro=null;
		Autore autore=null;
		for(int i=0;i<10;i++) {
			autore = new Autore("Autore: "+i);
			listaAutori.add(autore);
		}
		for(int i=0;i<100;i++) {
			int random=rand.nextInt(9);
			if(random==0) {
				libro=new Libro("Titolo: "+i, i);
				listaLibri.add(libro);
			}else {
				
				libro=new Libro("Titolo: "+i, i);
				
				for(int j=0;j<3;j++) {
					int randomAutore=rand.nextInt(listaAutori.size());
					libro.aggiungiAutore(listaAutori.get(randomAutore));
				}
				listaLibri.add(libro);
			}
		}
		for (int i = 0; i < listaLibri.size(); i++) {
		    for (int j = i + 1; j < listaLibri.size(); j++) {
		        Libro l1 = listaLibri.get(i);
		        Libro l2 = listaLibri.get(j);

		        if (l1.comparatorAutori(l2.getAutori())) {
		            System.out.println("I libri \"" + l1.getTitolo() + "\" e \"" + l2.getTitolo() + "\" hanno gli stessi autori.");
		        }
		    }
		}

		for(Libro entry:listaLibri) {
			System.out.println(entry.toString());
		}
		
		
	}
}
