package album;

import java.util.ArrayList;
import java.util.List;

public class Album {
	List<Figurina> listaFigurine=new ArrayList<Figurina>();
	public boolean addFigurina(int numero,Materiale materiale) {
		try {
			Figurina figurina=new Figurina(materiale,numero);
			listaFigurine.add(figurina);
			return true;
		}catch(Error e) {
			return false;
		}
	}
	public boolean removeFigurinaByNumero(int numero) {
		for(Figurina entry:listaFigurine) {
			if(entry.getNumeroFigurina()==numero) {
				listaFigurine.remove(entry);
				return true;
			}
		}
		throw new Error("Figurina non trovata");
	}
	//se è sport
	public boolean addFigurina(int numero,Materiale materiale,Sport sport) {
		try {
			Figurina figurina=new FigurinaSportiva(materiale,numero,sport);
			listaFigurine.add(figurina);
			return true;
		}catch(Error e) {
			return false;
		}
	}
	
	public List<Figurina> getFigurineOrderedByNumber(){
		List<Figurina> listaOdinata=new ArrayList<Figurina>(listaFigurine);
		listaOdinata.sort((f1,f2)->Integer.compare(f2.numeroFigurina, f1.numeroFigurina));
		return listaOdinata;
	}
	public List<Figurina> getFigurineGreaterOrdered(int numero){
		List<Figurina> listaOdinata=new ArrayList<Figurina>();
		for(Figurina entry:listaFigurine) {
			if(entry.getNumeroFigurina()>=numero) {
				listaOdinata.add(entry);
			}
		}
		listaOdinata.sort((f1,f2)->Integer.compare(f2.numeroFigurina, f1.numeroFigurina));
		return listaOdinata;
	}
	public List<Figurina>getFigurineByMateriale(Materiale materiale){
		List<Figurina> listaOdinata=new ArrayList<Figurina>();
		for(Figurina entry:listaFigurine) {
			if(entry.getMateriale().equals(materiale)) {
				listaOdinata.add(entry);
			}
		}
		
		return listaOdinata;
	}
	public List<Figurina> listaFigurine() {
		return listaFigurine;
		
	}
}
