package invetario.test;

import java.io.IOException;

import inventario.Invetario;
import inventario.Libro;
import inventario.testDue.TestDue;

public class Main {

	public static void main(String[] args) throws IOException {
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
		//inventario.removeLibro("SDA");
		//System.out.println("DOPO:");
		//inventario.Stampa();
		System.out.println( inventario.serechByTitle(libro3.getTitolo()));
		TestDue.salvataggioLibro("/home/lorenzocalabrese/GitHub/Java_Language/Lorenzo_InventarioLibro/src/Inventario.txt", inventario.getMappa());
		System.out.println("Lettura file");
		TestDue.letturaFile("/home/lorenzocalabrese/GitHub/Java_Language/Lorenzo_InventarioLibro/src/Inventario.txt");
	}

}
