package main;

import prodotto.Prodotti;
import prodotto.prodottiElettronici;
import prodotto.prodottoAlimentare;

public class TestNegozio {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		prodottoAlimentare prodottoAli1 = new prodottoAlimentare("1",10,"grassi",1);
		prodottoAlimentare prodottoAli2 = new prodottoAlimentare("2",8,"lipidi",-2);
		prodottiElettronici prodottoEle1 = new prodottiElettronici("1",1.80,4);
		prodottiElettronici prodottoELe2 = new prodottiElettronici("3",10,20);
	
		negozio negozio = new negozio(null);
		
		negozio.addProdotto(prodottoAli1);
		negozio.addProdotto(prodottoAli2);
		negozio.addProdotto(prodottoEle1);
		negozio.addProdotto(prodottoELe2);
		negozio.Stampa();
		
		
	}

}
