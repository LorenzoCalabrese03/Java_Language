package inventario.testDue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import inventario.Libro;

public class TestDue {

	public static void salvataggioLibro(String file,Map<Libro,Integer> mappa) throws IOException {
		try(PrintWriter writer = new PrintWriter(new FileWriter(file))){
			mappa.entrySet().stream().forEach(entry -> writer.println(entry.getKey()+" "+entry.getValue()));
		}
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
