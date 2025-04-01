package negozio;

public class ProdottoElettronico extends Prodotto {
	Categoria categoria;
	public ProdottoElettronico(String nome, double prezzo, String codice, int date, Categoria categoria) {
		super(nome, prezzo, codice, date);
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
		return super.toString()+" Categoria: "+getCategoria();
	}

}
