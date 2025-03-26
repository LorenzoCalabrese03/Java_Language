package magazzino;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Prodotto {
	String codice;
	String nome;
	double prezzo;
	LocalDateTime dataScadenza;
	TipoProdotto tipo;
	LocalDateTime x = LocalDateTime.now();
	public Prodotto(String codice, String nome, double prezzo, LocalDateTime dataScadenza, TipoProdotto tipo) {
		super();
		this.codice = codice;
		this.nome = nome;
		if(prezzo<0) {
			throw new Error("prezzo negativo");
		}else {
			this.prezzo = prezzo;
		}
		if(dataScadenza.isAfter(x)) {
			throw new Error("Data di scadenza non valida");
		}else {
			this.dataScadenza = dataScadenza;
		}
		
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String dataFormattata=getDataScadenza().format(formatter);
		return "Prodotto [codice=" + codice + ", nome=" + nome + ", prezzo=" + prezzo + ", dataScadenza=" + dataFormattata
				+ ", tipo=" + tipo + "]";
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public LocalDateTime getDataScadenza() {
		return dataScadenza;
	}
	public void setDataScadenza(LocalDateTime dataScadenza) {
		this.dataScadenza = dataScadenza;
	}
	public TipoProdotto getTipo() {
		return tipo;
	}
	public void setTipo(TipoProdotto tipo) {
		this.tipo = tipo;
	}
	
}
