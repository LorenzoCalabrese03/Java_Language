package magazzino;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class Prodotto {
	String nome;
	String codice;
	double prezzo;
	LocalDateTime annoProduzione;
	
	
	public Prodotto(String nome, String codice, double prezzo, LocalDateTime annoProduzione) {
		super();
		this.nome = nome;
		this.codice = codice;
		this.prezzo = prezzo;
		this.annoProduzione = annoProduzione;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public LocalDateTime getAnnoProduzione() {
		return annoProduzione;
	}
	public void setAnnoProduzione(LocalDateTime annoProduzione) {
		this.annoProduzione = annoProduzione;
	}


	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "Prodotto [nome=" + nome + ", codice=" + codice + ", prezzo=" + prezzo + ", annoProduzione="
				+ annoProduzione.format(formatter) + "]";
	}
	
	
}
