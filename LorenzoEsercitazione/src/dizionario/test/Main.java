package dizionario.test;

import dizionario.Dizionario;

public class Main {

	public static void main(String[] args) {
		Dizionario dizionario = new Dizionario();
		String ciao="Ciao";
		int numero=5;
		String ciao2="Lorenzo";
		int numero2=6;
		String ciao3="Francesco";
		int numero3=51;
		String ciao4="Alex";
		int numero4=54;
		dizionario.aggiuntaCoppia(ciao,numero);
		dizionario.aggiuntaCoppia(ciao2,numero2);
		dizionario.aggiuntaCoppia(ciao3,numero3);
		dizionario.aggiuntaCoppia(ciao4,numero4);
		dizionario.stampaMappa();
		dizionario.searchByName("Giuseppe");
		dizionario.trasformazioneInLista();
		dizionario.stampaLista();
	}

}
