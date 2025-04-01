package bibliotecaMultimediale;

public abstract class ProdottoMultimediale {
String titolo;
String autore;
int annoPubblicazione;
public ProdottoMultimediale(String titolo,String autore, int annoPubblicazione) {
	this.annoPubblicazione=annoPubblicazione;
	this.autore=autore;
	this.titolo=titolo;
}


@Override
public String toString() {
	return "ProdottoMultimediale [titolo=" + titolo + ", autore=" + autore + ", annoPubblicazione=" + annoPubblicazione
			+ "]";
}


public String getTitolo() {
	return titolo;
}

public void setTitolo(String titolo) {
	this.titolo = titolo;
}

public String getAutore() {
	return autore;
}

public void setAutore(String autore) {
	this.autore = autore;
}

public int getAnnoPubblicazione() {
	return annoPubblicazione;
}

public void setAnnoPubblicazione(int annoPubblicazione) {
	this.annoPubblicazione = annoPubblicazione;
}


}
