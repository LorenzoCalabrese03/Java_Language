package gestionale;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dipartimento {
	String nome;
	String indirizzo;
	int numeroPosti;
	List<Laboratorio> listaLaboratori=new ArrayList<Laboratorio>();
	List<Afferente> listaAfferenti=new ArrayList<Afferente>();
	Map<Laboratorio,List<Afferente>> laboratorioAfferente=new HashMap<Laboratorio,List<Afferente>>();
	
	public Dipartimento(String nome, String indirizzo, int numeroPosti) {
		super();
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.numeroPosti = numeroPosti;
	}
		public boolean aggiungiLaboratorio(Laboratorio lab) {
			for(Laboratorio entry:listaLaboratori) {
				if (entry.nome.equals(lab.nome)) {
					return false;
				}	
			}
			listaLaboratori.add(lab);
			return true;
		}
		public boolean aggiungiAfferente(Afferente persona, Laboratorio lab) {
		    boolean laboratorioTrovato = false;  // Flag per verificare se il laboratorio è presente nella lista

		    // Verifica se il laboratorio esiste nella lista
		    for (Laboratorio entry : listaLaboratori) {
		        if (entry.nome.equals(lab.nome)) {
		            laboratorioTrovato = true;  // Segna che il laboratorio è stato trovato
		            break;  // Esci dal ciclo se il laboratorio è trovato
		        }
		    }

		    // Se il laboratorio non è stato trovato, lancia un errore
		    if (!laboratorioTrovato) {
		        throw new Error("Non esiste il laboratorio");
		    }

		    // Verifica se la persona può essere aggiunta (non è già parte di un altro laboratorio)
		    if (!persona.getIsFaParte()) {
		        // Se la persona è un tesista, aggiungila al laboratorio
		        if (persona instanceof Tesista) {
		            persona.setFaParte(true);

		            // Aggiungi la persona alla lista di afferenti del laboratorio
		            laboratorioAfferente
		                .computeIfAbsent(lab, k -> new ArrayList<>())  // Se non esiste una lista, la crea
		                .add(persona);  // Aggiungi la persona al laboratorio

		            return true;  // Operazione riuscita
		        } else {
		            throw new Error("Non è un tesista");
		        }
		    } else {
		        throw new Error("Fa già parte di un laboratorio");
		    }
		}

	public boolean rimuoviAfferente(Afferente persona,Laboratorio lab) {
		for(Laboratorio entry:listaLaboratori) {
			if(entry.nome.equals(lab.nome)) {
				if(laboratorioAfferente.get(lab).contains(persona)) {
					laboratorioAfferente.get(lab).remove(persona);
					return true;
				}else {
					throw new NullPointerException("Persona non trovata");
				}
			}else {
				throw new NullPointerException("Laboratorio non trovato");
			}
		}
		return false;
	}
	public String maggiorTesisti() {
		Laboratorio laboratorioPrescelto=null;
		int maxTesisti=0;
		for(Map.Entry<Laboratorio, List<Afferente>> entry:laboratorioAfferente.entrySet()) {
			Laboratorio lab=entry.getKey();
			List<Afferente>afferenti=entry.getValue();
			int numero=0;
			for(Afferente afferente:afferenti) {
				numero++;
			}
			if(maxTesisti<numero) {
				maxTesisti=numero;
				laboratorioPrescelto=lab;
			}
		}
		return laboratorioPrescelto.nome;
	}
	public void getListaLab() {
		
	    for (Laboratorio entry : listaLaboratori) {
	        System.out.println(entry.toString());  // Stampa l'oggetto, che chiamerà automaticamente toString()
	    }
	}
	public List<Laboratorio> getListaLabs() {
		return listaLaboratori;
	}
}
