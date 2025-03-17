package videoTeca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VideoTeca {
	List<Film> listaFilm = new ArrayList<Film>();
	
	public boolean aggiungiFilm(String titolo,String autore,String codice,int anno,Genere genere) {
		try {
			Film film = new Film(titolo, autore, codice, anno, genere);
			listaFilm.add(film);
			return true;
		}catch(Error e){
			return false;
		}
	}
	public boolean aggiungiFilm(String titolo,String autore,String codice,int anno,TecnicaAnimazione animazione,Genere genere) {
		try {
			Film film = new FilmAnimazione(titolo, autore, codice, anno,animazione,genere);
			listaFilm.add(film);
			return true;
		}catch(Error e){
			return false;
		}
	}
	
	public boolean rimuoviFilmPerCodice(String codice) {
		for(Film entry:listaFilm) {
			if(entry.getCodice().equals(codice)) {
				listaFilm.remove(entry);
				return true;
			}
		}
		throw new Error("Film non trovato");
	}
	
	public List<Film> getFilmOrdinatiPerTitolo(){
		List<Film> listaOrdinata=new ArrayList<>(listaFilm);
		Collections.sort(listaOrdinata,Comparator.comparing(Film::getTitolo));
		return listaOrdinata;
	}
	public List<Film> getFilmDopoAnno(int anno){
		List<Film> listaOrdinata=new ArrayList<>();
		for(Film entry:listaFilm) {
			if(entry.getAnnoUscita()>anno) {
				listaOrdinata.add(entry);
			}
		}
		listaOrdinata.sort((f1,f2)->Integer.compare(f2.getAnnoUscita(), f1.getAnnoUscita()));
		return listaOrdinata;
	}
	
	public List<Film> getFilmPerGenere(Genere genere){
		List<Film> listaOrdinata=new ArrayList<>();
		for(Film entry:listaFilm) {
			if(entry.getGenere().equals(genere)) {
				listaOrdinata.add(entry);
			}
		}
		listaOrdinata.sort((f1,f2)->Integer.compare(f2.getAnnoUscita(), f1.getAnnoUscita()));
		return listaOrdinata;
	}
	public List<Film> getListaFilm(){
		return listaFilm;
	}
}

