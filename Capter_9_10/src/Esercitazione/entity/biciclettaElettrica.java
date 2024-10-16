package Esercitazione.entity;

import java.time.LocalDate;

public class biciclettaElettrica extends bicicletta {
	
	double autonomiaBatteria;
	int tensioneBatteria;
	
	public biciclettaElettrica(String modello, LocalDate annoDiProduzione, String telaio, int marce, int marciaImpostata,
						double autonomiaBatteria,int tensioneBatteria) {
		
		super(modello, annoDiProduzione, telaio, marce, marciaImpostata);
		// TODO Auto-generated constructor stub
		this.setAutonomiaBatteria(autonomiaBatteria);
		this.setTensioneBatteria(tensioneBatteria);
	}
	
	public double getAutonomiaBatteria() {
		return autonomiaBatteria;
	}

	public void setAutonomiaBatteria(double autonomiaBatteria) {
		this.autonomiaBatteria = autonomiaBatteria;
	}

	public int getTensioneBatteria() {
		return tensioneBatteria;
	}

	public void setTensioneBatteria(int tensioneBatteria) {
		this.tensioneBatteria = tensioneBatteria;
	}

	public void ricaricaBatteria() {
		System.out.println("Sta caricando");
	}

}
