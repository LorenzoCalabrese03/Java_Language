package Esame.test;

import java.util.Map;

import Esame.Persona;
import Esame.Ufficio;

public class TestSportello {
	public static void main(String[] args) {
	      Ufficio ufficio = new Ufficio(1, "Via Roma, 1",5);

	        // Creazione di 300 persone
	        for (int i = 1; i <= 120; i++) {
	            Persona persona = new Persona("Nome" + i, "Cognome" + i);
	            if (!ufficio.aggiungiPersona(persona)) {
	                System.out.println("Persona " + persona + " non accettata: ufficio pieno.");
	            }
	        }

	        // Stampare il numero di persone per sportello
	        Map<Integer, Integer> numeroPersoneMap = ufficio.getNumeroPersonePerSportello();
	        numeroPersoneMap.forEach((sportello, numeroPersone) ->
	                System.out.println("Sportello " + sportello + " ha " + numeroPersone + " persone in coda."));

	        // Servire 10 persone
	        for (int i = 0; i < 10; i++) {
	            Persona servita = ufficio.servirePersona();
	            if (servita != null) {
	                System.out.println("Servita: " + servita);
	            }
	        }

	        // Stampare sportelli
	        ufficio.stampaSportelli();

	}
}
