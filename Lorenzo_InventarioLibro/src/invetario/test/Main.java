package invetario.test;

import inventario.Invetario;
import inventario.Libro;

public class Main {

	public static void main(String[] args) {
		Invetario inventario = new Invetario();
		Libro libro= new Libro("Harry Potter");
		Libro libro2= new Libro("SDA");
		Libro libro3= new Libro("Harry Potter");
		Libro libro4= new Libro("SDA");
		
		inventario.aggiuntaLibro(libro.getTitolo(), 5);
		inventario.aggiuntaLibro(libro2.getTitolo(), 6);
		inventario.aggiuntaLibro(libro3.getTitolo(), 10);
		inventario.aggiuntaLibro(libro4.getTitolo(), 6);
		inventario.Stampa();
		inventario.removeLibro("SDA");
		System.out.println("DOPO:");
		inventario.Stampa();
		System.out.println( inventario.serechByTitle(libro3.getTitolo()));
	}

}
