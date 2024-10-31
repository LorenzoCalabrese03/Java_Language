package Entity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
public class Impiegato extends Persona {
		int codiceImpiegato;
		String mansione;
		LocalDate dataAssunzione;
		String luogo;
		File contratto;
		String filePath;
	
		ArrayList<String>Luoghi=new ArrayList<String>();//aggiungi gli elementi
	Impiegato(int codicePersona, String nome, String cognome, boolean assunto, int codiceImpiegato,String mansione,String luogo) throws ExceptionImpiegato {
		super(codicePersona, nome, cognome, assunto);
		setCodiceImpiegato(codiceImpiegato);
		setMansione(mansione);
		setDataAssunzione();
		setLuogo(luogo);
		
	}
	public File getContratto() {
		return contratto;
	}
	public void setContratto(File contratto) throws ExceptionImpiegato, IOException {
		 String filePath = getFilePath();
	     File fileContratto = new File(filePath);
	     try {
	    	 if(fileContratto.exists()) {
			this.contratto = fileContratto;
		}else {
			System.out.println("File non presente\nCreazione in corso...");
			boolean create = fileContratto.createNewFile();
			if(create) {
				System.out.println("File creato con successo.");
				 // Scrivi "Contratto all'interno" nel nuovo file
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileContratto))) {
                    writer.write("Contratto all'interno");
                }

                // Assegna il nuovo file alla variabile 'contratto'
                this.contratto = fileContratto;
			}else {
				throw new IOException("Impossibile creare il file");
			}
		}
	  }catch(IOException e) {
		  
	  }
	}
	
	public ArrayList<String> getLuoghi() {
		return Luoghi;
	}
	public void setLuoghi(ArrayList<String> luoghi) {
		
		Luoghi = luoghi;
	}
	public String getLuogo() {
		return luogo;
	}
	public void setLuogo(String luogo) throws ExceptionImpiegato {
		boolean fleg=false;
		for(String entry:Luoghi) {
			if(luogo.equals(entry)) {
				this.luogo = luogo;
				fleg = true;
			}
		}
		if(fleg==false) {
			throw new ExceptionImpiegato("Luogo non presente");
		}
	}
	public LocalDate getDataAssunzione() {
		return dataAssunzione;
	}
	public void setDataAssunzione() {
		this.dataAssunzione = LocalDate.now();
	}
	public int getCodiceImpiegato() {
		return codiceImpiegato;
	}
	public void setCodiceImpiegato(int codiceImpiegato) throws ExceptionImpiegato {
		if(codiceImpiegato<=0) {
			throw new ExceptionImpiegato("Codice negativo");
		}else {
			this.codiceImpiegato = codiceImpiegato;
		}
		
	}
	public String getMansione() {
		return mansione;
	}
	public void setMansione(String mansione) throws ExceptionImpiegato {
		if(mansione.isEmpty()||mansione==null) {
			throw new ExceptionImpiegato("Mansione vuota");
		}else {
			this.mansione = mansione;
		}
		
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = String.valueOf(getCodiceImpiegato());
	}
	public String formattazioneData(LocalDate dataAssunzione) {
		DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return getDataAssunzione().format(formatoData);
	}

}
