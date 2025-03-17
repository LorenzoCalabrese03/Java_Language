package album.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import album.Album;
import album.Figurina;
import album.Materiale;
import album.Sport;
import test.due.album.TestDueAlbum;

public class Main {

	public static void main(String[] args) {
		int numero=70;
		Album album= new Album();
		
		List<Materiale> materiale= new ArrayList<Materiale>();
		List<Sport> sport= new ArrayList<Sport>();
		List<Figurina> listaOrdinata= new ArrayList<Figurina>();
		materiale.add(Materiale.Carta);
		materiale.add(Materiale.CartaAdesiva);
		materiale.add(Materiale.Plastica);
		
		sport.add(Sport.Calcio);
		sport.add(Sport.Nuoto);
		sport.add(Sport.Sci
				);
		Random rand= new Random();
		try {
			//genera 50 figurine
			for(int i=1;i<=numero;i++) {
			int tipoFigurina=rand.nextInt(2);
			int random=rand.nextInt(materiale.size());
			if(tipoFigurina==1) {
				System.out.println(album.addFigurina(i, materiale.get(random)));
			}else {
				System.out.println(album.addFigurina(i, materiale.get(random),sport.get(random)));
			}
			
		}
		}catch(Error e) {
			System.out.println(e.getMessage());
		}
		
		//album.listaFigurine();
		//ORDINAMENTO DECRESCENTE
		//listaOrdinata=album.getFigurineOrderedByNumber();
//		
//		for(Figurina entry:listaOrdinata) {
//			System.out.println(entry.toString());
//		}
		
		//IN BASE AL MATERIALE
//		listaOrdinata=album.getFigurineByMateriale(Materiale.Plastica);
//		
//		for(Figurina entry:listaOrdinata) {
//			System.out.println(entry.toString());
//		}
		
		//IN BASE AD UN NUMERO
		listaOrdinata=album.getFigurineGreaterOrdered(25);
		
//		for(Figurina entry:listaOrdinata) {
//			System.out.println(entry.toString());
//		}
//		
		TestDueAlbum.salvaAlbum(album.listaFigurine(), "/home/lorenzocalabrese/eclipse-workspace/Esercitazione_Ardimento/src/figurine.txt");
		TestDueAlbum.salvaAlbumOrdinato(listaOrdinata, "/home/lorenzocalabrese/eclipse-workspace/Esercitazione_Ardimento/src/figurineOrdinate.txt");
	}
	

}
