package veicoli;

public class Veicolo {
	String codice;
	double costo;
	double velocitàMassima;
	
	
	public Veicolo(String codice, double costo, double velocitàMassima) {
		super();
		this.codice = codice;
		if(costo<0) {
			throw new Error("Il costo non può essere negativo");
		}else {
			this.costo = costo;
		}
		if(velocitàMassima<0) {
			throw new Error("La velocità non può essere negativo");
		}else {
			this.velocitàMassima = velocitàMassima;
		}
		
	}
	
//	public Veicolo(Veicolo first) {
//		this.codice=first.codice;
//		this.costo=first.costo;
//		this.velocitàMassima=first.velocitàMassima;
//	}

	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public double getVelocitàMassima() {
		return velocitàMassima;
	}
	public void setVelocitàMassima(double velocitàMassima) {
		this.velocitàMassima = velocitàMassima;
	}

	@Override
	public String toString() {
		return "Veicolo [codice=" + codice + ", costo=" + calcolaCosto(costo) + ", velocitàMassima=" + velocitàMassima + "]";
	}
	
	public double calcolaCosto(double costo) {
		return costo;
	}
	
}
