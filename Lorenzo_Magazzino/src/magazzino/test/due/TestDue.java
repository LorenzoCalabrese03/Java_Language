package magazzino.test.due;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.List;

import magazzino.Prodotto;

public class TestDue {
	
		public static void salvataggioProdotti(List<Prodotto> listaProdotti,String file) throws IOException {
			// TODO Auto-generated method stub
			DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			try(PrintWriter writer= new PrintWriter (new FileWriter(file))){
				for(Prodotto entry:listaProdotti) {
					writer.println(entry.toString());
				}
				System.out.println("salvato");
			}
		}
	public static void letturaFile(String file) throws FileNotFoundException, IOException {
		try(BufferedReader reader=new BufferedReader(new FileReader(file))){
			String riga;
			
			while((riga=reader.readLine())!=null) {
				System.out.println(riga);
			}
		}
	}

}
