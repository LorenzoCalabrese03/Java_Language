package gestionale;

public class Laboratorio {
	Strutturato responsabile;
	String nome;
	public Laboratorio(Strutturato responsabile, String nome) {
		super();
		this.responsabile = responsabile;
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Laboratorio [responsabile=" + responsabile + ", nome=" + nome + "]";
	}
	
}
