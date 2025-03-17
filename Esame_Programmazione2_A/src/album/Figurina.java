package album;

public class Figurina {
	Materiale materiale;
	int numeroFigurina;
	public Figurina(Materiale materiale, int numeroFigurina) {
		super();
		this.materiale = materiale;
		setNumeroFigurina(numeroFigurina);
	}
	public Materiale getMateriale() {
		return materiale;
	}
	public void setMateriale(Materiale materiale) {
		this.materiale = materiale;
	}
	public int getNumeroFigurina() {
		return numeroFigurina;
	}
	public void setNumeroFigurina(int numeroFigurina) {
		if(numeroFigurina<1||numeroFigurina>60) {
			throw new Error("numero fuori reange;");
		}
		this.numeroFigurina = numeroFigurina;
	}
	@Override
	public String toString() {
		return "Figurina [materiale=" + materiale + ", numeroFigurina=" + numeroFigurina + "]";
	}
	
}
