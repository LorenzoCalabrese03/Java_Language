package biblioteca;

public class Utente {
	static int idIncr=1;
	int id;
	String nome;
	String cognome;
	Categoria categoria;
	public Utente(String nome,String cognome,Categoria cate) {
		super();
		this.nome = nome;
		this.id=idIncr++;
		this.cognome=cognome;
		this.categoria=cate;
	}
	@Override
	public String toString() {
		return "Utente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", categoria=" + categoria + "]";
	}
	
}
