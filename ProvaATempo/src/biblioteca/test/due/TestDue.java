package biblioteca.test.due;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import biblioteca.ElementoMultimediale;

public class TestDue {

	public static void SalvataggioFile(Map<String,ElementoMultimediale> mappa,String file) throws IOException {
		// TODO Auto-generated method stub
		try(PrintWriter writer = new PrintWriter(new FileWriter(file))){
			mappa.entrySet().stream().forEach(entry->writer.println("Chiave: "+entry.getKey()+" Valore:"+entry.getValue()) );
			System.out.print("Stampato\n");
		}
	}
	public static void LetturaFile(String file) throws FileNotFoundException, IOException {
		try(BufferedReader reader = new BufferedReader(new FileReader(file))){
			String riga;
			System.out.println("Lettura file");
			while((riga=reader.readLine())!=null){
				System.out.println(riga);
			}
		}
	}

}
