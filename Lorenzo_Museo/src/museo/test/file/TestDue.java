package museo.test.file;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import museo.Opera;

public class TestDue {

	public static void salvataggioOpera(List<Opera> lista,String file) throws IOException {
		try(PrintWriter writer = new PrintWriter(new FileWriter(file))){
			for(Opera entry:lista) {
				writer.println(entry.toString());
			}
			System.out.println("Salvato");
		}

	}

}
