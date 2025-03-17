package videoTeca;

public class Film {
	String titolo;
	String regista;
	String codice;
	int annoUscita;
	Genere genere;
	
	public Film(String titolo, String regista, String codice, int annoUscita,Genere genere) {
		super();
		try {
		this.titolo = titolo;
		this.regista = regista;
		this.codice = codice;
		this.genere=genere;
		setAnnoUscita(annoUscita);;
		}catch(Error e) {
			e.getMessage();
		}
		
	}
	
	public Genere getGenere() {
		return genere;
	}

	public void setGenere(Genere genere) {
		this.genere = genere;
	}

	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getRegista() {
		return regista;
	}
	public void setRegista(String regista) {
		this.regista = regista;
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public int getAnnoUscita() {
		return annoUscita;
	}
	public void setAnnoUscita(int annoUscita) {
		if(annoUscita<1895||annoUscita>2025) {
			throw new Error("Anno non Valido");
		}
		this.annoUscita = annoUscita;
	}
	@Override
	public String toString() {
		return "Film [titolo=" + titolo + ", regista=" + regista + ", codice=" + codice + ", annoUscita=" + annoUscita
				+" Genere: "+genere+ "]";
	}
	
}
