package Entity;

public class Persona {
	int codicePersona;
	String nome;
	String cognome;
	boolean assunto;
	Persona(int codicePersona,String nome,String cognome,boolean assunto){
		setCodicePersona(codicePersona);
		setNome(nome);
		setCognome(cognome);
		setAssunto(assunto);
	}
	public int getCodicePersona() {
		return codicePersona;
	}
	public void setCodicePersona(int codicePersona) {
		this.codicePersona = codicePersona;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public boolean isAssunto() {
		return assunto;
	}
	public void setAssunto(boolean assunto) {
		this.assunto = assunto;
	}
}
