package veicoli;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GestoreVeicoli {
	List<Veicolo> listaVeicoli =new ArrayList<Veicolo>();
	
	public boolean aggiungiVeicolo(String codice,double costo,double velocitàMassima) {
			
			for(Veicolo entry:listaVeicoli) {
				if(entry.getCodice()==codice){
					return false;
				}
			}
			Veicolo veicolo = new Veicolo(codice,costo,velocitàMassima); 
			listaVeicoli.add(veicolo);
			return true;
		}
		
	public boolean aggiungiVeicolo(String codice,double costo,double velocitàMassima,int autonomia,Batterie tipoBatteria) {
		
		for(Veicolo entry:listaVeicoli) {
			if(entry.getCodice()==codice){
				return false;
			}
		}
		VeicoloElettrico veicolo = new VeicoloElettrico(codice,costo,velocitàMassima,autonomia,tipoBatteria); 
		listaVeicoli.add(veicolo);
		return true;
	}
	public boolean rimuoviVeicolo(String codice) {
		for(Veicolo entry:listaVeicoli) {
			if(entry.getCodice()==codice){
				listaVeicoli.remove(entry);
				return true;
			}
		}
		return false;
	}
	
	public List<Veicolo> getLista(int filtro) {
	    List<Veicolo> listaOrdinata = new ArrayList<Veicolo>(listaVeicoli);
	    switch(filtro) {
	        case 1:
	            System.out.println("Veicoli più veloci in ordine discendente");
	            listaOrdinata.sort((v1, v2) -> Double.compare(v2.getVelocitàMassima(), v1.getVelocitàMassima()));
	            break;
	        case 2:
	            listaOrdinata.clear();
	            System.out.println("Veicoli con costo inferiore a 23K");
	            for (Veicolo entry : listaVeicoli) {
	                if (entry.getCosto() < 24) {
	                    listaOrdinata.add(entry);
	                }
	            }
	            break;
	        case 3:
	            System.out.println("Veicoli con lettera A nel codice");
	            for (Veicolo entry : listaVeicoli) {
	                if (entry.getCodice().startsWith("A")) {
	                    listaOrdinata.add(entry);
	                }
	            }
	            break;
	        case 4:
	            System.out.println("Veicolo più veloce");
	            Veicolo veicoloPiuVeloce = null;
	            for (Veicolo v : listaOrdinata) {
	                if (veicoloPiuVeloce == null || v.getVelocitàMassima() > veicoloPiuVeloce.getVelocitàMassima()) {
	                    veicoloPiuVeloce = v;
	                }
	            }
	            listaOrdinata.clear(); // Svuota la lista
	            if (veicoloPiuVeloce != null) {
	                listaOrdinata.add(veicoloPiuVeloce); // Aggiungi il veicolo più veloce
	            }
	            break;
	    }
	    return listaOrdinata;
	}

}
