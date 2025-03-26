package magazzino;

import java.time.LocalDateTime;

;

public class ProdottoAlimentare extends Prodotto {
	TipoProdottoAlimentare categoria;
	public ProdottoAlimentare(String codice, String nome, double prezzo, LocalDateTime dataScadenza, TipoProdotto tipo,TipoProdottoAlimentare categoria) {
		super(codice, nome, prezzo, dataScadenza, tipo);
		this.categoria=categoria;
		// TODO Auto-generated constructor stub
	}
	public TipoProdottoAlimentare getCategoria() {
		return categoria;
	}
	public void setCategoria(TipoProdottoAlimentare categoria) {
		this.categoria = categoria;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" Categoria:" +getCategoria();
	}

	
	
}
