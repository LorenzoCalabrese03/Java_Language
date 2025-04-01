package negozio;


public class Prodotto {
	String nome;
	double prezzo;
	String codice;
	int date;
	
	
	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public Prodotto(String nome, double prezzo, String codice, int date) {
		super();
		this.nome = nome;
		this.prezzo = prezzo;
		this.codice = codice;
		this.date = date;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Prodotto [nome=" + nome + ", prezzo=" + prezzo + ", codice=" + codice + ", date=" + date + "]";
	}
	
}
