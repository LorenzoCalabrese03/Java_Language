package inventario;

public class Libro {
	String titolo;

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Libro(String titolo) {
		super();
		this.titolo = titolo;
	}

	@Override
	public String toString() {
		return "Libro [titolo=" + titolo + "]";
	}
	
}
