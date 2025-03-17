package test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import gestionale.Afferente;
import gestionale.Dipartimento;
import gestionale.Dottorando;
import gestionale.Grado;
import gestionale.Laboratorio;
import gestionale.Strutturato;
import gestionale.Tesista;

public class main {
	
	public static void main(String[] args) {
		List<Strutturato> listaStrutturato=new ArrayList<Strutturato>();
		List<Dottorando> listaDottorando=new ArrayList<Dottorando>();
		List<Tesista> listaTesisti=new ArrayList<Tesista>();
		Dipartimento Informatica=new Dipartimento("Informatica", "Bari", 20);
		Random rand = new Random();
		ArrayList<Grado> gradi=new ArrayList<Grado>();
		gradi.add(Grado.Associato);
		gradi.add(Grado.Ordinario);
		gradi.add(Grado.Ricercatore);
		
			for(int i=1;i<=50;i++) {
				int numeroCas=rand.nextInt(20);
				if (i >= 1 && i <= 20) {
					int numeroGrado=rand.nextInt(3);
				    listaStrutturato.add(new Strutturato("Strutturato " + i, "cognome " + i, gradi.get(numeroGrado)));
				} else if (i >= 21 && i <= 30) {
					
				    listaDottorando.add(new Dottorando("Dottorando: " + i, "cognome: " + i, 1, listaStrutturato.get(numeroCas)));
				} else if (i >= 31 && i <= 50) {
				    listaTesisti.add(new Tesista("nome " + i, "cognome " + i, "Titolo:"+i, listaStrutturato.get(numeroCas)));
				} 
			}
//			System.out.println("Strutturati");
//			for(Afferente entry:listaStrutturato) {
//				System.out.println(entry.toString());
//			}
//			System.out.println("\nDottorandi");
//			for(Afferente entry:listaDottorando) {
//				System.out.println(entry.toString());
//			}
//			System.out.println("\nStudenti");
//			for(Tesista entry:listaTesisti) {
//				System.out.println(entry.toString());
//			}
			Laboratorio Bool = new Laboratorio(listaStrutturato.get(2), "Bool");
			System.out.println(Informatica.aggiungiLaboratorio(Bool));
			
			Laboratorio Von = new Laboratorio(listaStrutturato.get(4), "Von");
			System.out.println(Informatica.aggiungiLaboratorio(Von));
			
			Laboratorio NewMan = new Laboratorio(listaStrutturato.get(4), "NewMan");
			System.out.println(Informatica.aggiungiLaboratorio(NewMan));
			int numeroCas=rand.nextInt(Informatica.getListaLabs().size());
			
			for(Tesista entry:listaTesisti) {
				Laboratorio lab = Informatica.getListaLabs().get(numeroCas);
				Informatica.aggiungiAfferente(entry, lab);
			}
			
			System.out.println("Maggiori Tesisti nel laboratorio: "+Informatica.maggiorTesisti());
			Informatica.getListaLab();
	}
}
