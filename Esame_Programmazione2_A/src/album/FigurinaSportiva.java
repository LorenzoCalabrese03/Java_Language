package album;

public class FigurinaSportiva extends Figurina {
	Sport sport;
	public FigurinaSportiva(Materiale materiale, int numeroFigurina,Sport sport) {
		super(materiale, numeroFigurina);
		this.sport=sport;
	}
	public Sport getSport() {
		return sport;
	}
	public void setSport(Sport sport) {
		this.sport = sport;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" Sport:"+sport;
	}

}
