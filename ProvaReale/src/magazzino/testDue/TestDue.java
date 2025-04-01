package magazzino.testDue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import magazzino.Prodotto;

public class TestDue {

	public static void salvataggioFile(String file,List<Prodotto> listaProdotti) throws IOException {
		try(PrintWriter writer = new PrintWriter(new FileWriter(file))){
			listaProdotti.stream().forEach(entry->writer.println(entry.toString()));
		}
		System.out.println("Salvato");
	}
	
	public static void letturaFile(String file) throws FileNotFoundException, IOException {
		try(BufferedReader reader = new BufferedReader(new FileReader(file))){
			String riga;
			while((riga=reader.readLine())!=null) {
				System.out.println(riga);
			}
		}
	}

}
