package biblioteca;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pubblicazione implements Sconto{
	String titolo;
	LocalDateTime data;
	double prezzo;
	public Pubblicazione(String titolo, LocalDateTime data, double prezzo) {
		super();
		this.titolo = titolo;
		this.data = data;
		this.prezzo = prezzo;
	}
	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "Pubblicazione [titolo=" + titolo + ", data=" + getData().format(formatter) + "]";
	}

	@Override
	public double calcoloSconto() {
		
		return getPrezzo();
	}
	
	
}
