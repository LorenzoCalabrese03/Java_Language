package biblioteca;

import java.time.LocalDateTime;

public class Libro extends Pubblicazione implements Sconto{
	int numeroPagine;
	public Libro(String titolo, LocalDateTime data, double prezzo, int numeroPagine) {
		super(titolo, data, prezzo);
		this.numeroPagine=numeroPagine;
		// TODO Auto-generated constructor stub
	}
	@Override
	public double calcoloSconto() {
		return  getPrezzo()*0.1;
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Libro: "+ super.toString()+"Prezzo: "+calcoloSconto();
	}

}
