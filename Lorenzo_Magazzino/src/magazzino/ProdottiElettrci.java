package magazzino;

import java.time.LocalDateTime;


public class ProdottiElettrci extends Prodotto{
	int garanzia;
	public ProdottiElettrci(String codice, String nome, double prezzo, LocalDateTime dataScadenza, TipoProdotto tipo,int garanzia) {
		super(codice, nome, prezzo, dataScadenza, tipo);
		this.garanzia=garanzia;
		// TODO Auto-generated constructor stub
	}
	
	public int getGaranzia() {
		return garanzia;
	}

	public void setGaranzia(int garanzia) {
		this.garanzia = garanzia;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" Garanzia: "+getGaranzia();
	}

}
