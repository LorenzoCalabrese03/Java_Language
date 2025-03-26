package mappe;

import java.util.HashMap;
import java.util.Map;

public class FunzioniMappe {
	
	public static void conteggioOccorrenze(String frase) {
		String[] parole = frase.split(" ");//divide la frase in parole
		Map<String,Integer>paroleConteggio= new HashMap<String,Integer>();
		for(String entry:parole) {
			entry = entry.toLowerCase();
			paroleConteggio.put(entry, paroleConteggio.getOrDefault(entry, 0)+1);//conta le occorrenze
		}
		paroleConteggio.entrySet().forEach(entry->System.out.println(entry.getKey()+" "+entry.getValue()));
	}
	
	public static void OrdinamentoStringa(Map<Integer,String>mappa) {
		mappa.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(entry->System.out.println(entry.getKey()+" "+entry.getValue()));
		
	}
	
	public static void OrdinamentoStudenti(Map<String,Integer>mappa) {
		mappa.entrySet().stream().sorted((Map.Entry.comparingByValue())).forEach(entry->System.out.println(entry.getKey()+" "+entry.getValue()));;
	}
}
