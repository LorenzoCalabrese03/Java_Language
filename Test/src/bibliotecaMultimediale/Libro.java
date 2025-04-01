package bibliotecaMultimediale;

public class Libro extends ProdottoMultimediale {
String isbn;
	public Libro(String isbn,String titolo,String autore,int annoPubblicazione) {
		super(titolo, autore, annoPubblicazione);
		this.isbn=isbn;
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" ISBN: "+isbn;
	}



}
