package prodotto;

public class prodottiElettronici extends Prodotti {
	private int garanzia;
	public prodottiElettronici(String codice, double prezzoIniziale, int garanzia) {
		super(codice, prezzoIniziale);
		if(garanzia<2||garanzia>24) {
			this.setGaranzia(2);
		}else {
			this.setGaranzia(garanzia);
		}
		
		// TODO Auto-generated constructor stub
	}
	public int getGaranzia() {
		return garanzia;
	}
	public void setGaranzia(int garanzia) {
		this.garanzia = garanzia;
	}
@Override
public
 double calcolaCosto(){
	double costo=prezzoIniziale;
	if(getGaranzia()>=12) {
		costo += (prezzoIniziale*0.1);
	}
	return costo;
}
@Override
public void Stampa() {
	System.out.println("prodotto elettronico: " +"\nCodice: "+ getCodice()+"\nCosto iniziale: "+getPrezzoIniziale()+"\nCosto Calcolato: "+calcolaCosto()+"\nGaranzia: "+getGaranzia());
}
}
