package mappe;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		Map<String,Integer> mappaStudenti = new HashMap<String,Integer>();
		mappaStudenti.put("Marco", 85);
        mappaStudenti.put("Giulia", 92);
        mappaStudenti.put("Luca", 78);
        mappaStudenti.put("Anna", 88);
        mappaStudenti.put("Paolo", 95);
        
        FunzioniMappe.OrdinamentoStudenti(mappaStudenti);
        
        String frase = "java è fantastico java è divertente java";
        FunzioniMappe.conteggioOccorrenze(frase);
	}

}
