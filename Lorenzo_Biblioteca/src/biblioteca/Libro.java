package biblioteca;

public class Libro {
int id;
String titolo;
String autore;
boolean dispo;
public Libro(int id, String titolo, String autore, boolean dispo) {
	super();
	this.id = id;
	this.titolo = titolo;
	this.autore = autore;
	this.dispo = dispo;
}
@Override
public String toString() {
	return "Libro [id=" + id + ", titolo=" + titolo + ", autore=" + autore + ", dispo=" + dispo + "]";
}
public boolean isDispo() {
	return dispo;
}
public void setDispo(boolean dispo) {
	this.dispo = dispo;
}

}
