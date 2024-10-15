package prodotto;

public class prodottoAlimentare extends Prodotti {
		private String principioNutritivo;
		private int tempoConservazione;
	public prodottoAlimentare(String codice, double prezzoIniziale, String principioNutritivo,int tempoConservazione) {
		super(codice, prezzoIniziale);
		// TODO Auto-generated constructor stub
		this.setPrincipioNutritivo(principioNutritivo);
		if(tempoConservazione<1) {
			this.setTempoConservazione(1);
		}else {
			this.setTempoConservazione(tempoConservazione);
		}
		
	}
	public String getPrincipioNutritivo() {
		return principioNutritivo;
	}
	public void setPrincipioNutritivo(String principioNutritivo) {
		this.principioNutritivo = principioNutritivo;
	}
	public int getTempoConservazione() {
		return tempoConservazione;
	}
	public void setTempoConservazione(int tempoConservazione) {
		this.tempoConservazione = tempoConservazione;
	}
	@Override
	public double calcolaCosto() {
		double costo=prezzoIniziale;
		if(tempoConservazione==1) {
			costo/=2;
		}
		return costo;
	}
	@Override
	public void Stampa() {
		System.out.println("prodotto alimentare: " +"\nCodice: "+ getCodice()+"\nprezzo iniziale: "+getPrezzoIniziale()+"\nCosto Calcolato: "+calcolaCosto()
		+"\ntempo conservazione: "+tempoConservazione + "\nprincipio nutritivo: " + getPrincipioNutritivo() );
	}
}
