package Esercitazione.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class veicolo {
	String modello;
	LocalDate annoDiProduzione;
	veicolo(String modello, LocalDate annoDiProduzione){
		this.setAnnoDiProduzione(annoDiProduzione);
		this.setModello(modello);
	}
	public abstract void clacson();
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public LocalDate getAnnoDiProduzione() {
		return annoDiProduzione;
	}
	public void setAnnoDiProduzione(LocalDate annoDiProduzione) {
		this.annoDiProduzione = annoDiProduzione;
	}
	
	
}
