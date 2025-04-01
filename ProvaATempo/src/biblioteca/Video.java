package biblioteca;

public class Video extends ElementoMultimediale {
	String risoluzione;
	
	public Video(String codice, String titolo, int durata, TipoFileMultimediale tipo,String risoluzione) {
		super(codice, titolo, durata, tipo);
		// TODO Auto-generated constructor stub
		this.risoluzione=risoluzione;
		
	}

	public String getRisoluzione() {
		return risoluzione;
	}

	public void setRisoluzione(String risoluzione) {
		this.risoluzione = risoluzione;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+"Risoluzione: "+risoluzione;
	}

}
