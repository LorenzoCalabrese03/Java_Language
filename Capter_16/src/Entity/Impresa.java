package Entity;

public class Impresa {
	int codiceImpresa;
	int numeroImpiegati;
	String nome;
	Impresa(int codiceImpresa,int numeroImpiegati,String nome){
		setCodiceImpresa(codiceImpresa);
		setNome(nome);
	}
	public int getCodiceImpresa() {
		return codiceImpresa;
	}
	public void setCodiceImpresa(int codiceImpresa) {
		this.codiceImpresa = codiceImpresa;
	}
	public int getNumeroImpiegati() {
		return numeroImpiegati;
	}
	public void setNumeroImpiegati(int numeroImpiegati) {
		this.numeroImpiegati = numeroImpiegati;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void assumi() {
		
	}
}
