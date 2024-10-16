package Esercitazione.entity;

import java.time.LocalDate;
import java.util.Scanner;


public abstract class bicicletta extends veicolo {
	String telaio;
	int marce;
	int marciaImpostata;
	
	public bicicletta(String modello, LocalDate annoDiProduzione,String telaio,int marce ,int marciaImpostata) {
		super(modello, annoDiProduzione);
		// TODO Auto-generated constructor stub
		this.setMarce(marce);
		this.setMarciaImpostata(marciaImpostata);
	}
	
	public String getTelaio() {
		return telaio;
	}


	public void setTelaio(String telaio) {
		this.telaio = telaio;
	}


	public int getMarce() {
		return marce;
	}


	public void setMarce(int marce) {
		if (marce<4&&marce>6) {
			this.marce = 0;
		}else {
			this.marce = marce;
		}
		
	}


	public int getMarciaImpostata() {
		return marciaImpostata;
	}


	public void setMarciaImpostata(int marciaImpostata) {
		if(marciaImpostata>=1&&marciaImpostata<=getMarce()) {
			this.marciaImpostata = marciaImpostata;
		}else {
			this.marciaImpostata = 0;
		}
		
	}
	

	/**
	 * cambio di marcia
	 * */
	
	public void cambioMarcia() {
		Scanner scanner = new Scanner(System.in);
		if(marce==0) {
			System.out.println("Le marce non sono valide");
		}
		System.out.println("seleziona la marcia da mettere tra quelle disponibili:\nPer uscire digita qualsiasi cosa");
		for(int i=4;i<=marce;i++) {
			System.out.println(">"+i);
		}
		System.out.println("scegli:\n>");
		int scelta=scanner.nextInt();
		switch(scelta) {
		case 4:
			System.out.println("nuova marcia: "+scelta);
			break;
		case 5:
			System.out.println("nuova marcia: "+scelta);
			break;
		case 6:
			System.out.println("nuova marcia: "+scelta);
			break;
		
		}
	}
	@Override
	 public void clacson() {
		System.out.println("Suono bici");
	}

}
