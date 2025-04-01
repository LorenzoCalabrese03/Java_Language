package biblioteca;

public abstract class ElementoMultimediale {
	String codice;
	String titolo;
	int durata;
	TipoFileMultimediale tipo;
	public ElementoMultimediale(String codice, String titolo, int durata, TipoFileMultimediale tipo) {
		super();
		setCodice(codice);
		this.titolo = titolo;
		setDurata(durata);
		this.tipo=tipo;
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		if(codice==null) {
			throw new Error("il codice deve essere presente");
			
		}else {
			this.codice = codice;
		}
		
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public int getDurata() {
		return durata;
	}
	public void setDurata(int durata) {
		if(durata<0) {
			throw new Error("Durata negativa");
		}else {
			this.durata = durata;
		}
		
	}
	public TipoFileMultimediale getTipo() {
		return tipo;
	}
	public void setTipo(TipoFileMultimediale tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "ElementoMultimediale [codice=" + codice + ", titolo=" + titolo + ", durata=" + durata + ", tipo=" + tipo
				+ "]";
	}
	
	
}
