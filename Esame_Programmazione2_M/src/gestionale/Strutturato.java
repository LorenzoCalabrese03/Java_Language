package gestionale;

public class Strutturato extends Afferente {
	Grado grado;
	public Strutturato(String nome, String cognome,Grado grado) {
		super(nome, cognome);
		this.grado=grado;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" Grado= "+grado;
	}

}
