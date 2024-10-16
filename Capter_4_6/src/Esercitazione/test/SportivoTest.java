package Esercitazione.test;

import java.util.Date;
import java.util.Scanner;

import Esercitazioni.entity.Sportivo;
/**
 * 
 * This is the main of the project
 * 
 * */

public class SportivoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * n is the number of Sportsman
		 * top30 the Array
		 * 
		 * */
		int n=2;
		Sportivo[] top30 = new Sportivo[n];
		Date data = new Date() ;
		/**
		 * scanner is the object  that take the input
		 * */
		Scanner scanner = new Scanner(System.in);
		Scanner scannerInt = new Scanner(System.in);
		
		for(int i=0; i<top30.length;i++) {
		
		System.out.println("Inserisci cognome: ");
		String cognome = scanner.nextLine();
		System.out.println("Inserisci il rank: ");
		int rank = scannerInt.nextInt();
		/**ready to take a Date from the input*/
		top30[i] = new Sportivo(cognome,rank,data);
		/**ready to take Date from the system*/
		top30[i] = new Sportivo(cognome,rank);
		}
		
		/**
		 * Function to print the top30's components
		 *  */
		Stampa(top30);
		
	}
	static void Stampa(Sportivo[] top30) {
		int counter=0;
		for(int i=0;i<top30.length;i++) {
			/**
			 * if the cognome is null we count it and than print it
			 * */
			if(top30[i].getCognome()=="$") {
				counter++;
			}else {
				/**
				 * print cognome,rank(with the letter) and date*/
			System.out.println("Cognome: "+ top30[i].getCognome()+"\nRank: "+top30[i].getLetterRanking()+
					"\nData di iscrizione: "+ top30[i].getDataDiscrizione());
			/**
			 * we print if the Sportsman are rated or not
			 * */
			switch(top30[i].getLetterRanking()) {
			/**
			 * A,B,C 
			 * RATED
			 * */
			case 'A','B','C':
				System.out.println("Cognome: "+ top30[i].getCognome()+" Classificato");
				break;
				/**
				 * D or something else
				 * NOT RATED
				 * */
			default:
				System.out.println("Cognome: "+ top30[i].getCognome()+" NON Classificato");
				
				}
			
			}
			
		}
		
		System.out.println("Persone senza cognome: " + counter);
	}

}
