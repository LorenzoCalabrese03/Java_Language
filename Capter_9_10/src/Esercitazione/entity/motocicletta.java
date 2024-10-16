package Esercitazione.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class motocicletta extends veicolo {
	
	String tipoGuida;
	int cilindrata;
	
	public motocicletta(String modello, LocalDate annoDiProduzione,String tipoGuida,int cilindrata	) {
		super(modello, annoDiProduzione);
		// TODO Auto-generated constructor stub
		this.setCilindrata(cilindrata);
		this.setTipoGuida(tipoGuida);
	}
	
	public void setTipoGuida(String tipoGuida) {
		
		if(tipoGuida.toLowerCase().equals("moderata")||tipoGuida.toLowerCase().equals("brillante")||tipoGuida.toLowerCase().equals("sportiva")) {
			this.tipoGuida = tipoGuida;
		}else {
			this.tipoGuida = "";
		}
		
	}
	public String getTipoGuida() {
		return tipoGuida;
	}
	public int getCilindrata() {
		return cilindrata;
	}

	public void setCilindrata(int cilindrata) {
		if(cilindrata<1000&&cilindrata>2500) {
			this.cilindrata = 0;
		}else {
			this.cilindrata = cilindrata;
		}
		
	}

	
	/**
	 * Simula l'accellerazione della moto
	 * */
	public void accellera() {
		System.out.println("Vrum");
	}
	@Override
	public void clacson() {
		// TODO Auto-generated method stub
		System.out.println("Suono motocilcetta");
	}

}
