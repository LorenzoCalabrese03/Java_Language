package veicoli.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import veicoli.Batterie;
import veicoli.GestoreVeicoli;
import veicoli.Veicolo;

public class Main {

	public static void main(String[] args) {
		GestoreVeicoli gestore = new GestoreVeicoli();
		List<Veicolo> listaVeicoli = new ArrayList<Veicolo>();
		Random rand= new Random();
		
		List<Batterie> batterie=new ArrayList<Batterie>();
		batterie.add(Batterie.Esotico);
		batterie.add(Batterie.Litio);
		batterie.add(Batterie.LitiPoli);
		
		for(int i = 1; i < 50; i++) {
		    // Genera un carattere casuale tra 'A' e 'Z'
		    char randomLetter = (char) ('A' + rand.nextInt(26));  // 26 è il numero di lettere nell'alfabeto

		    // Genera una scelta casuale per il veicolo
		    int randomScelta = rand.nextInt(2);
		    int randomBatteria = rand.nextInt(batterie.size());

		    // Usa la lettera casuale per il codice del veicolo
		    if (randomScelta == 1) {
		        System.out.println(gestore.aggiungiVeicolo((randomLetter) + String.valueOf(i), i + 20, i + 100));
		    } else {
		        System.out.println(gestore.aggiungiVeicolo((randomLetter) + String.valueOf(i), i + 20, i + 100, i + 20, batterie.get(randomBatteria)));
		    }
		}
		
		listaVeicoli=gestore.getLista(0);
		
		for(Veicolo entry:listaVeicoli) {
			System.out.println(entry.toString());
		}
	}

}
