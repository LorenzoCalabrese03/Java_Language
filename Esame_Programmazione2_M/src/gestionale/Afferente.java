package gestionale;

public class Afferente {
	static int increMat=1;
	int matricola;
	String nome;
	String cognome;
	boolean faParte;
	public Afferente(String nome,String cognome) {
		this.matricola=increMat++;
		this.cognome=cognome;
		this.nome=nome;
	}
	public boolean getIsFaParte() {
		return faParte;
	}
	public void setFaParte(boolean faParte) {
		this.faParte = faParte;
	}
	@Override
	public String toString() {
		return "Afferente [matricola=" + matricola + ", nome=" + nome + ", cognome=" + cognome + ", Fa Parte="
				+ getIsFaParte();
	}
	
}
