package biblioteca;

import java.time.LocalDateTime;

public class Rivista extends Pubblicazione implements Sconto {
	int numeroVolume;
	public Rivista(String titolo, LocalDateTime data, double prezzo, int numeroVolume) {
		super(titolo, data, prezzo);
		this.numeroVolume=numeroVolume;
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcoloSconto() {
		
		return getPrezzo()*0.5;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Rivista: "+super.toString()+"Prezzo: "+ calcoloSconto();
	}

}
