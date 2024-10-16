package Esercitazione.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class macchina extends veicolo {
	int numeroPorte;
	double consumo;
	public macchina(String modello, LocalDate annoDiProduzione,int numeroPorte,double consumo) {
		super(modello, annoDiProduzione);
		// TODO Auto-generated constructor stub
		this.setConsumo(consumo);
		this.setNumeroPorte(numeroPorte);
	}

	@Override
	public void clacson() {
		// TODO Auto-generated method stub
		System.out.println("Suono macchina");
	}
	double calcolaConsumo() {
		if(annoDiProduzione.getYear()<2010) {
			return consumo*0.2;
		}else {
			return consumo;
		}
		
		
	}

	public int getNumeroPorte() {
		return numeroPorte;
	}

	public void setNumeroPorte(int numeroPorte) {
		if(numeroPorte>=3&&numeroPorte<=6) {
			this.numeroPorte = numeroPorte;
		}else {
			this.numeroPorte = 0;
		}
		
	}

	public double getConsumo() {
		return consumo;
	}

	public void setConsumo(double consumo) {
		if(consumo<0.2&&consumo>0.9) {
			this.consumo = 0;
		}else {
			this.consumo = consumo;
		}
		
	}

}
