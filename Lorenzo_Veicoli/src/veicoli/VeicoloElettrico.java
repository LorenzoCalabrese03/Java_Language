package veicoli;

public class VeicoloElettrico extends Veicolo {
	int autonomia;
	Batterie tipoBatteria;
	public VeicoloElettrico(String codice, double costo, double velocitàMassima,int autonomia,Batterie tipoBatteria) {
		super(codice, costo, velocitàMassima);
		this.autonomia=autonomia;
		this.tipoBatteria=tipoBatteria;
		// TODO Auto-generated constructor stub
	}
	public int getAutonomia() {
		return autonomia;
	}
	public void setAutonomia(int autonomia) {
		this.autonomia = autonomia;
	}
	public Batterie getTipoBatteria() {
		return tipoBatteria;
	}
	public void setTipoBatteria(Batterie tipoBatteria) {
		this.tipoBatteria = tipoBatteria;
	}
	
	@Override
	public double calcolaCosto(double costo) {
		if(tipoBatteria.equals("LitiPoli")) {
			return super.calcolaCosto(costo)*0.1;
		}
		return super.calcolaCosto(costo);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" Autonomia "+getAutonomia()+" Tipo Batteria "+getTipoBatteria();
	}

}
