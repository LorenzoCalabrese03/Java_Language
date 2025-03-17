package gestionale;

public class Tesista extends Afferente {
	String titoloTesi;
	Strutturato relatore;
	Dottorando correlatore;
	public Tesista(String nome, String cognome,String titoloTesi,Strutturato relatore,Dottorando correlatore) {
		super(nome, cognome);
		this.titoloTesi=titoloTesi;
		this.relatore=relatore;
		this.correlatore=correlatore;
	}
	public Tesista(String nome, String cognome,String titoloTesi,Strutturato relatore) {
		super(nome, cognome);
		this.titoloTesi=titoloTesi;
		this.relatore=relatore;
	
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(correlatore!=null) {
			return super.toString()+"Titolo: "+titoloTesi+" Relatore: "+relatore+"Correlatore "+correlatore;
		}else {
			return super.toString()+"Titolo: "+titoloTesi+" Relatore: "+relatore;
		}
		
	}
	
}
