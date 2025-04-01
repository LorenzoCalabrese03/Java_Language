package bibliotecaMultimediale;

public class EBook extends ProdottoMultimediale {
	Formato formato;
	public EBook(String titolo, String autore, int annoPubblicazione,Formato formato) {
		super(titolo, autore, annoPubblicazione);
		this.formato=formato;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" Formato: "+formato;
	}



}
