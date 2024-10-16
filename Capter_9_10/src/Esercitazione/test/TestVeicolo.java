package Esercitazione.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import Esercitazione.entity.*;
import Esercitazione.entity.biciclettaElettrica;


public class TestVeicolo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate dataProduzione =  LocalDate.of(2020, 1, 1);//poi metti le variavili
		ArrayList<veicolo> ListaVeicolo = new ArrayList<veicolo>();
		ListaVeicolo.add(new macchina("Lancia", dataProduzione, 5, 0.9));
		ListaVeicolo.add(new motocicletta("Ducati", dataProduzione, "Moderata", 1200));
		ListaVeicolo.add(new biciclettaElettrica("BMX", dataProduzione, "12-BGw45", 5, 2, 12, 1200));
	     for (veicolo entry : ListaVeicolo) {
	    	 System.out.println();
	            if (entry instanceof macchina) {
	                macchina macchina = (macchina) entry; // Cast a Macchina
	                System.out.println("Modello: " + macchina.getModello() +
	                                   "\nData produzione: " + macchina.getAnnoDiProduzione() +
	                                   "\nNumero porte: " + macchina.getNumeroPorte());
	                entry.clacson();
	            } else if (entry instanceof motocicletta) {
	                motocicletta motocicletta = (motocicletta) entry; // Cast a Motocicletta
	                System.out.println("Modello: " + motocicletta.getModello() +
	                                   "\nData produzione: " + motocicletta.getAnnoDiProduzione()+
	                                   "\nCilindrata: "+motocicletta.getCilindrata()+"\nStile: "+motocicletta.getTipoGuida());
	                entry.clacson();
	            } else if (entry instanceof biciclettaElettrica) {
	            	biciclettaElettrica bicicletta = (biciclettaElettrica) entry; // Cast a Bicicletta
	                System.out.println("Modello: " + bicicletta.getModello() +
	                                   "\nData produzione: " + bicicletta.getAnnoDiProduzione());
	                entry.clacson();
	                bicicletta.ricaricaBatteria();
	                bicicletta.cambioMarcia();
	     
	                
	            }
	        }
	     
			
		}
		
	}


