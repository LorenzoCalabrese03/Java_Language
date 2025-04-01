package bibliotecaMultimediale.test.due;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import bibliotecaMultimediale.ProdottoMultimediale;

public class TestDue {

	public static void salvataggio(List<ProdottoMultimediale> lista,String file) throws IOException {
		try(PrintWriter writer = new PrintWriter(new FileWriter(file))){
			lista.stream().forEach(l->writer.println(l.toString()));
		}
		System.out.println("Salvato");

	}

}
