package libro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Libro {
	private String titolo;
	private List<Autore> autori = new ArrayList<Autore>();
	private double prezzo;
	
	
	public Libro(String titolo, double prezzo) {
		super();
		this.titolo = titolo;
		this.prezzo = prezzo;
	}
	public boolean aggiungiAutore(Autore autore) {
		for (Autore entry : autori) {
			if (entry.equals(autore)) {
				System.out.println("Autore già presente");
				return false;
			}
		}
		this.autori.add(autore);
		ordinamento();
		return true;
	}

	
	public boolean rimuoviAutore(Autore autore) {
		for(Autore entry:autori) {
			if(entry.equals(autore)) {
				autori.remove(entry);
				ordinamento();
				return true;
			}
		}
		return false;
	}
	public boolean comparatorAutori(List<Autore> listaAutori) {
		if(listaAutori.equals(autori)) {
			return true;
		}
		return false;
	}
	
	public boolean faParte(Autore autore) {
		for(Autore entry:autori) {
			if(entry.equals(autore)) {
				return true;
			}
		}
		return false;
	}
	
	private void ordinamento() {
		Collections.sort(autori,Comparator.comparing(Autore::getNome));
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public List<Autore> getAutori() {
		return autori;
	}
	public void setAutori(List<Autore> autori) {
		this.autori = autori;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	@Override
	public String toString() {
		return "Libro [titolo=" + titolo + ", autori=" + autori + ", prezzo=" + prezzo + "]";
	}
	
	
}
