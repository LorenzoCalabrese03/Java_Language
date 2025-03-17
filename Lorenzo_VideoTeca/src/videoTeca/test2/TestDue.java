package videoTeca.test2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import videoTeca.Film;

public class TestDue {

	public static void salvataggioFilm(List<Film>lista,String file) throws IOException {
		try(PrintWriter writer=new PrintWriter(new FileWriter(file))){
			for(Film entry:lista) {
				writer.println(entry.toString());
				
			}
			System.out.println("Salvato con successo");
		}
	}
	public static void salvataggioFilmOrdinati(List<Film>lista,String file) throws IOException {
		try(PrintWriter writer=new PrintWriter(new FileWriter(file))){
			for(Film entry:lista) {
				writer.println(entry.toString());
				
			}
			System.out.println("Salvato con successo");
		}
	}
}
