package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	List<Libro> libri=new ArrayList<Libro>();
	public boolean aggiungiLibro(Libro lib) {
		for(Libro entry:libri) {
			if((entry.id==lib.id)) {
				throw new Error("Libro già presente");
				
			}
		}
		libri.add(lib);
		return true;
	}
	
	List<Utente> utenti=new ArrayList<Utente>();
	public boolean aggiungiUtente(Utente utente) {
		for(Utente entry:utenti) {
			if((entry.id==utente.id)) {
				throw new Error("Utente già presente");
				
			}
		}
		utenti.add(utente);
		return true;
	}
	List<Prestito> listaPrestiti=new ArrayList<Prestito>();
	public boolean prestito(Utente utente, Libro lib, int data) {
	    for (Libro entry : libri) {
	        if (entry.id == lib.id) {  // Controlla se il libro è lo stesso
	            if (entry.dispo) {  // Se è disponibile, procedi con il prestito
	                entry.setDispo(false); // Imposta il libro come non disponibile
	                Prestito prestito = new Prestito(utente, entry, data);
	                listaPrestiti.add(prestito);
	                return true; // Prestito effettuato con successo
	            } else {
	                throw new Error("Libro non disponibile");
	            }
	        }
	    }
	    throw new Error("Libro non trovato"); // Se nessun libro corrisponde
	}

	public List<Prestito> listaPrestiti(){
		return listaPrestiti;
	}
	public boolean restituzione(int id) {
		for(Prestito entry:listaPrestiti) {
			if(entry.id==id) {
				
				for(Libro entryLibro:libri) {
					if(entryLibro==entry.getLibro()) {
						entryLibro.dispo=true;
						listaPrestiti.remove(entry);
						return true;
						
					}
				}
				throw new Error("Libro non trovato nella lista");
			}
			
		}
		throw new Error("Prestito non trovato");
		
	}
	
	public List<Libro> listaLirbi(){
		return libri;
	}
	public List<Prestito> prestitiOrdinati(){
		List<Prestito> prestitiOrdinat = new ArrayList<>(listaPrestiti);
		prestitiOrdinat.sort((l1,l2)->Integer.compare(l1.data, l2.data));
		return prestitiOrdinat;
	}
}
