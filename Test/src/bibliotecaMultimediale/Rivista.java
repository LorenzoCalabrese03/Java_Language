package bibliotecaMultimediale;

public class Rivista extends ProdottoMultimediale {
	int numeroRivista;
	public Rivista(String titolo, String autore, int annoPubblicazione, int numeroRivista) {
		super(titolo, autore, annoPubblicazione);
		this.numeroRivista=numeroRivista;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" Numero Rivista: "+numeroRivista;
	}


}
