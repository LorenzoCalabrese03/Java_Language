package museo;

public class Scultura extends Opera {
	Materiale materiale;
	
	public Scultura(String titolo, String artista, int id, int annoCreazione, TipoOpera tipo,Materiale materiale) {
		super(titolo, artista, id, annoCreazione, tipo);
		this.materiale=materiale;
	}

	public Materiale getMateriale() {
		return materiale;
	}

	public void setMateriale(Materiale materiale) {
		this.materiale = materiale;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" Materiale: "+getMateriale();
	}

	
}
