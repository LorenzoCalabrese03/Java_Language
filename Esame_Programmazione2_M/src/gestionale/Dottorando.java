package gestionale;

public class Dottorando extends Afferente {
	int anno;
	Strutturato responsabile;
	public Dottorando(String nome, String cognome,int anno,Strutturato responsabile) {
		super(nome, cognome);
		this.anno=anno;
		this.responsabile=responsabile;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" Anno= "+anno+"Responsabile= "+responsabile;
	}

}
