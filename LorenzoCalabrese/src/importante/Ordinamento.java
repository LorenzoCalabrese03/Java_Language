package importante;


public class Ordinamento {
	
	//Ordinamento per Titolo/Stringa
	/*	public List<Opera> getOpereOrdinatePerTitolo(){
		List<Opera> listaOrdinata = new ArrayList<Opera>(listaOpere);
		Collections.sort(listaOrdinata,Comparator.comparing(Opera::getTitolo));
		return listaOrdinata;
	}*/
	
	//Ordinamento per un valore di enum
//	public List<Opera> getOperaPerTipo(TipoOpera tipo){
//		List<Opera> listaOrdinata = new ArrayList<Opera>();
//		for(Opera entry:listaOpere) {
//			if(entry.getTipo().equals(tipo)) {
//				listaOrdinata.add(entry);
//			}
//		}
//		return listaOrdinata;
//	}
	
	
	//Ordinamento per filtro, importante caso 4
	/*public List<Veicolo> getLista(int filtro) {
	    List<Veicolo> listaOrdinata = new ArrayList<Veicolo>(listaVeicoli);
	    switch(filtro) {
	        case 1:
	            System.out.println("Veicoli più veloci in ordine discendente");
	            listaOrdinata.sort((v1, v2) -> Double.compare(v2.getVelocitàMassima(), v1.getVelocitàMassima()));
	            break;
	        case 2:
	            listaOrdinata.clear();
	            System.out.println("Veicoli con costo inferiore a 23K");
	            for (Veicolo entry : listaVeicoli) {
	                if (entry.getCosto() < 24) {
	                    listaOrdinata.add(entry);
	                }
	            }
	            break;
	        case 3:
	            System.out.println("Veicoli con lettera A nel codice");
	            for (Veicolo entry : listaVeicoli) {
	                if (entry.getCodice().startsWith("A")) {
	                    listaOrdinata.add(entry);
	                }
	            }
	            break;
	        case 4:
	        
	            System.out.println("Veicolo più veloce");
	            Veicolo veicoloPiuVeloce = null;
	            for (Veicolo v : listaOrdinata) {
	                if (veicoloPiuVeloce == null || v.getVelocitàMassima() > veicoloPiuVeloce.getVelocitàMassima()) {
	                    veicoloPiuVeloce = v;
	                }
	            }
	            listaOrdinata.clear(); // Svuota la lista
	            if (veicoloPiuVeloce != null) {
	                listaOrdinata.add(veicoloPiuVeloce); // Aggiungi il veicolo più veloce
	            }
	            break;
	    }
	    return listaOrdinata;
	}
	
	//Ordinamento data
		public List<Prodotto> getProdottiOrdinatiPerDataScadenza(){
		List<Prodotto> listaOrdinata=new ArrayList<Prodotto>(listaProdotti);
		listaOrdinata.stream().sorted(Comparator.comparing(Prodotto::getDataScadenza));
		return listaOrdinata;
	}
	*/
	
	
}
