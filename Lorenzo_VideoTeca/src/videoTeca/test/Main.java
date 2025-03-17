package videoTeca.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import videoTeca.Film;
import videoTeca.Genere;
import videoTeca.TecnicaAnimazione;
import videoTeca.VideoTeca;
import videoTeca.test2.TestDue;

public class Main {

	public static void main(String[] args) throws IOException {
		List<Genere> generi = new ArrayList<Genere>();
		generi.add(Genere.Animazione);
		generi.add(Genere.Azione);
		generi.add(Genere.Commendia);
		generi.add(Genere.Drammatico);
		generi.add(Genere.Fantaasy);
		
		List<TecnicaAnimazione> tecniche=new ArrayList<TecnicaAnimazione>();
		tecniche.add(TecnicaAnimazione.dueD);
		tecniche.add(TecnicaAnimazione.treD);
		tecniche.add(TecnicaAnimazione.Stop_Motion);
		
		VideoTeca teca = new VideoTeca();
		Random rand=new Random();
		
		for(int i=1;i<50;i++) {
			int scelta=rand.nextInt(2);
			int random=rand.nextInt(generi.size());
			int randomTecnica=rand.nextInt(tecniche.size());
			if(scelta==1) {
				System.out.println(teca.aggiungiFilm("titolo"+i, "autore"+i, "codice"+i, 1895+i, generi.get(random)));
			}else {
				System.out.println(teca.aggiungiFilm("titolo"+i, "autore"+i, "codice"+i, 1895+i,tecniche.get(randomTecnica) ,generi.get(random)));
			}	
			
		}
		
		List<Film> listaOrdinata=new ArrayList<Film>();
		
		//listaOrdinata=teca.getFilmOrdinatiPerTitolo();
		//listaOrdinata=teca.getFilmDopoAnno(1925);
		listaOrdinata=teca.getFilmPerGenere(Genere.Commendia);
		
		for(Film entry:listaOrdinata) {
			System.out.println(entry.toString());
		}
		TestDue.salvataggioFilm(teca.getListaFilm(), "/home/lorenzocalabrese/eclipse-workspace/Lorenzo_VideoTeca/src/Film");
		TestDue.salvataggioFilmOrdinati(listaOrdinata, "/home/lorenzocalabrese/eclipse-workspace/Lorenzo_VideoTeca/src/FilmOrdinati");
	}

}
