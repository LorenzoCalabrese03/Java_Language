package bibliotecaMultimediale;

public class AudioLibro extends ProdottoMultimediale {
	int durata;
	public AudioLibro(String titolo, String autore, int annoPubblicazione, int durata) {
		super(titolo, autore, annoPubblicazione);
		this.durata=durata;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" Durata: "+durata;
	}


}
