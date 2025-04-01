package bibliotecaMultimediale;

public class Bibliotecario {
	String nome;
	String cogonme;
	public Bibliotecario(String nome, String cogonme) {
		super();
		this.nome = nome;
		this.cogonme = cogonme;
	}
	
	public void aggiungiProdottoAllaBiblioteca(Biblioteca biblioteca,ProdottoMultimediale prodotto) {
		biblioteca.aggiungiProdotto(prodotto);
	}
	public void rimuoviProdottoAllaBiblioteca(Biblioteca biblioteca,String titolo) {
		biblioteca.rimuoviProdotto(titolo);
	}
}
