package Esame;

public class Persona {
	private String nome;
	private String cognome;
	private final int id;
	private static int idCounter=1;
	
	public Persona(String nome, String cognome) {
		setNome(nome);
		setCognome(cognome);
		this.id=idCounter++;
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
	public int getId() {
		return id;
	}
	  @Override
	    public String toString() {
	        return id + " - " + nome + " " + cognome;
	    }


}
