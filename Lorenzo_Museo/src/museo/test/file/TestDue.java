package museo.test.file;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import museo.Opera;

public class TestDue {

	public static void salvataggioOpera(List<Opera> lista,String file) throws IOException {
		try(PrintWriter writer = new PrintWriter(new FileWriter(file))){
			LocalDateTime data = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy HH:mm:ss");
			
			for(Opera entry:lista) {
				writer.println(entry.toString()+ " "+data.format(formatter));
			}
			System.out.println("Salvato");
			writer.close();
		}	
	}


public static void letturaOpere(String file) throws IOException {
 

    // Creiamo un BufferedReader per leggere il file riga per riga
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        String riga;
        
        // Leggiamo ogni riga del file
        while ((riga = reader.readLine()) != null) {
           System.out.println(riga);
        }
    }


}
}
