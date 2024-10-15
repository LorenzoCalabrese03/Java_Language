package main;
import java.util.ArrayList;
import java.util.List;

import prodotto.Prodotti;

public class negozio {
	private List<Prodotti> prodotti;
	
	negozio(Prodotti prodotto){
		this.prodotti =  new ArrayList<Prodotti>();
	}
//	public void setProdotto(Prodotti prodotto) {
//		this.prodotto=prodotto;
//	}
    public void addProdotto(Prodotti prodotto) {
        if (prodotto != null) {
            prodotti.add(prodotto); // Aggiunta del prodotto alla lista
        } else {
            System.out.println("Impossibile aggiungere un prodotto nullo.");
        }
    }
	double calcolaTotale() {
		double totale=0;
		
		for(Prodotti prodotto : prodotti) {
			totale += prodotto.calcolaCosto();
			
		}
		
		return totale;
	}
	public void Stampa() {
		   for (Prodotti prodotto : prodotti) {
			   System.out.println("");
	            prodotto.Stampa();
	        }
		   System.out.println("\nTotale: " + calcolaTotale());
	}
}
