package museo;

public class Opera {
	String titolo;
	String artista;
	int id;
	int annoCreazione;
	TipoOpera tipo;
	
	public Opera(String titolo, String artista, int id, int annoCreazione, TipoOpera tipo) {
		super();
		this.titolo = titolo;
		this.artista = artista;
		this.id = id;
		this.annoCreazione = annoCreazione;
		this.tipo = tipo;
	}

	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getArtista() {
		return artista;
	}
	public void setArtista(String artista) {
		this.artista = artista;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAnnoCreazione() {
		return annoCreazione;
	}
	public void setAnnoCreazione(int annoCreazione) {
		if(annoCreazione<1000||annoCreazione>2025) {
			throw new Error("Data non valida");
		}
		this.annoCreazione = annoCreazione;
	}
	public TipoOpera getTipo() {
		return tipo;
	}
	public void setTipo(TipoOpera tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "Opera [titolo=" + titolo + ", artista=" + artista + ", id=" + id + ", annoCreazione=" + annoCreazione
				+ ", tipo=" + tipo + "]";
	}
	
}
