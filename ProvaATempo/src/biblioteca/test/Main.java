package biblioteca.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;


import biblioteca.TipoFileMultimediale;
import biblioteca.Video;
import biblioteca.test.due.TestDue;
import biblioteca.ElementoMultimediale;
import biblioteca.Audio;
import biblioteca.BibliotecaMultimediale;
public class Main {

	public static void main(String[] args) throws IOException {
		List<TipoFileMultimediale> listaTipo = new ArrayList<TipoFileMultimediale>();
		listaTipo.add(TipoFileMultimediale.Audio);
		listaTipo.add(TipoFileMultimediale.Video);
		BibliotecaMultimediale biblioteca = new BibliotecaMultimediale();
		Random rand = new Random();
			for(int i=1;i<50;i++) {
				int random = rand.nextInt(listaTipo.size());
				if(random==0) {
					ElementoMultimediale elemento = new Audio("Codice: "+i, "Titolo: "+i, i, listaTipo.get(random), i );
					System.out.println(biblioteca.aggiungiElemento(elemento));
				}else {
					ElementoMultimediale elemento = new Video("Codice: "+i, "Titolo: "+i, i, listaTipo.get(random), "Risoluzione: "+i);
					System.out.println(i+" "+biblioteca.aggiungiElemento(elemento));
				}
			}
			
		Map<String,ElementoMultimediale> mappa= biblioteca.getLista();
		List<ElementoMultimediale> lista= biblioteca.filtra(TipoFileMultimediale.Audio);
		Optional<ElementoMultimediale> elemento=biblioteca.getElementoDurataMaggiore();
		mappa.entrySet().stream().forEach(entry->System.out.println(entry.getValue().toString()));
		lista.stream().forEach(entry->System.out.println("Solo tipo filtrato: "+entry.toString()));
		System.out.println("Elemento con durata maggiore: "+elemento.toString());
		TestDue.SalvataggioFile(mappa, "/home/lorenzocalabrese/GitHub/Java_Language/ProvaATempo/src/Prova.txt");
		TestDue.LetturaFile("/home/lorenzocalabrese/GitHub/Java_Language/ProvaATempo/src/Prova.txt");
	}

}
