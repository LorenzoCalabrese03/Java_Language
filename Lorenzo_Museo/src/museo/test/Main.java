package museo.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import museo.Materiale;
import museo.Museo;
import museo.Opera;

import museo.TipoOpera;
import museo.test.file.TestDue;

public class Main {

	public static void main(String[] args) throws IOException {
		List<TipoOpera> tipi = new ArrayList<TipoOpera>();
		tipi.add(TipoOpera.Dipinto);
		tipi.add(TipoOpera.Fotografia);
		tipi.add(TipoOpera.Installazione);
		tipi.add(TipoOpera.Sculutra);

		List<Materiale> materiali = new ArrayList<Materiale>();
		materiali.add(Materiale.Argilla);
		materiali.add(Materiale.Bronzo);
		materiali.add(Materiale.Legno);
		materiali.add(Materiale.Marmo);
		
		List<Opera> listaOpere=new ArrayList<Opera>();
		Random rand= new Random();
		
		Museo museo=new Museo();
		for(int i=1; i<50;i++) {
			int random=rand.nextInt(materiali.size());
			TipoOpera tipo=tipi.get(random);
			int randomMateriale=rand.nextInt(materiali.size());
			if(tipo.equals(TipoOpera.Sculutra)) {
				System.out.println(museo.aggiungiOpera("Titolo: "+i, "Autore: "+i, i, 999+i, tipi.get(random), materiali.get(randomMateriale)));
			}else {
				System.out.println(museo.aggiungiOpera("Tiolo: "+i, "Autore: "+i, i, 999+i, tipi.get(random)));
			}
		}
		
		listaOpere=museo.getListaOpere();
		//listaOpere=museo.getOperaDopoAnno(1020);
		//listaOpere=museo.getOpereOrdinatePerTitolo();
		//listaOpere=museo.getOperaPerTipo(TipoOpera.Sculutra);
		for(Opera entry:listaOpere) {
			System.out.println(entry.toString());
		}
		
		TestDue.salvataggioOpera(listaOpere, "/home/lorenzocalabrese/eclipse-workspace/Lorenzo_Museo/src/Opere");
	}

}
