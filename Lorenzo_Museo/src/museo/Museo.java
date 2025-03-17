package museo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Museo {
	List<Opera> listaOpere=new ArrayList<Opera>();
	
	public boolean aggiungiOpera(String titolo,String autore,int id,int anno,TipoOpera tipo) {
		boolean flag=false;
		Opera opera=new Opera(titolo,autore,id,anno,tipo);
		listaOpere.add(opera);
		flag=true;
		return flag;
	}
	public boolean aggiungiOpera(String titolo,String autore,int id,int anno,TipoOpera tipo,Materiale materiale) {
		boolean flag=false;
		Scultura opera=new Scultura(titolo,autore,id,anno,tipo,materiale);
		listaOpere.add(opera);
		flag=true;
		return flag;
	}
	
	public boolean rimuoviOpera(int id) {
		for(Opera entry:listaOpere) {
			if(entry.id==id) {
				listaOpere.remove(entry);
				return true;
			}
		}
		return false;
	}
	
	public List<Opera> getOpereOrdinatePerTitolo(){
		List<Opera> listaOrdinata = new ArrayList<Opera>(listaOpere);
		Collections.sort(listaOrdinata,Comparator.comparing(Opera::getTitolo));
		return listaOrdinata;
	}
	
	public List<Opera> getOperaDopoAnno(int anno){
		List<Opera> listaOrdinata = new ArrayList<Opera>();
		for(Opera entry:listaOpere) {
			if(entry.annoCreazione>=anno) {
				listaOrdinata.add(entry);
			}
		}
		return listaOrdinata;
	}
	
	public List<Opera> getOperaPerTipo(TipoOpera tipo){
		List<Opera> listaOrdinata = new ArrayList<Opera>();
		for(Opera entry:listaOpere) {
			if(entry.getTipo().equals(tipo)) {
				listaOrdinata.add(entry);
			}
		}
		return listaOrdinata;
	}
	
	public List<Opera> getListaOpere(){
		return listaOpere;
	}
	
}
