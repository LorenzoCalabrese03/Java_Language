package magazzino;

import java.time.LocalDateTime;

public class ProdottoAlimentare extends Prodotto {
	Categoria categoria;
	public ProdottoAlimentare(String nome, String codice, double prezzo, LocalDateTime annoProduzione,Categoria categoria) {
		super(nome, codice, prezzo, annoProduzione);
		this.categoria=categoria;
		
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+"Categoria: "+getCategoria();
	}

}
