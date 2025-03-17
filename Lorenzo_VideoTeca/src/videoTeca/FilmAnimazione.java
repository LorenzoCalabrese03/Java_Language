package videoTeca;

public class FilmAnimazione extends Film {
	
	TecnicaAnimazione tecnica;
	
	public FilmAnimazione(String titolo, String regista, String codice, int annoUscita,TecnicaAnimazione tecnica,Genere genere) {
		super(titolo, regista, codice, annoUscita, genere);
		this.tecnica=tecnica;
		// TODO Auto-generated constructor stub
	}

	public TecnicaAnimazione getTecnica() {
		return tecnica;
	}

	public void setTecnica(TecnicaAnimazione tecnica) {
		this.tecnica = tecnica;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" Tecnica: "+tecnica;
	}

	
	
}
