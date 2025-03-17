package biblioteca;

public class Prestito {
static int idIncr=1;
int id;
Utente utente;
Libro libro;
int data;
public Prestito( Utente utente, Libro libro, int data) {
	super();
	this.id = idIncr++;
	this.utente = utente;
	this.libro = libro;
	this.data = data;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Utente getUtente() {
	return utente;
}
public void setUtente(Utente utente) {
	this.utente = utente;
}
public Libro getLibro() {
	return libro;
}
public void setLibro(Libro libro) {
	this.libro = libro;
}
public int getData() {
	return data;
}
public void setData(int data) {
	this.data = data;
}
@Override
public String toString() {
	return "Prestito [id=" + id + ", utente=" + utente + ", libro=" + libro + ", data=" + data + "]";
}

}
