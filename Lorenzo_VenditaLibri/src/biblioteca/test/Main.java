package biblioteca.test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import biblioteca.Biblioteca;
import biblioteca.Libro;
import biblioteca.Pubblicazione;
import biblioteca.Rivista;

public class Main {

	public static void main(String[] args) {
		List<Pubblicazione> listaPubblicazioni = new ArrayList<Pubblicazione>();
		Random rand=new Random();
		Biblioteca biblioteca=new Biblioteca();
		LocalDateTime data=LocalDateTime.now();
		for(int i=1;i<=20;i++) {
			int random=rand.nextInt(2);
			if(random==1) {
				Libro libro = new Libro("Tiolo:" +i, data, i+20, i);
				biblioteca.aggiungiPubblicazione(libro);
			}else {
				Rivista rivista = new Rivista("Tiolo:" +i, data, i+20 , i);
				biblioteca.aggiungiPubblicazione(rivista);
			}
		}
		listaPubblicazioni=biblioteca.getPubblicazionePerDataPubblicazione();
		for(Pubblicazione entry:listaPubblicazioni) {
			System.out.println(entry.toString());
		}
	}

}
