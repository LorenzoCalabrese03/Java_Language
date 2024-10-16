package Esercitazioni.entity;
/**
 * 
 * This class represents a Sportsman
 * 
 * Sportsman: cognome (surname), rank (represents the position in the standings), dataDiIscrizione (the date of registration).
 * 
 * 
 * */
import java.util.Date;
import java.util.Optional;

import java.text.SimpleDateFormat;
import java.util.regex.Pattern;
public  class Sportivo {
	String cognome;
	int rank;
	Date dataDiscrizione;
	String formato;
	/**
	 * Constructor who Initializes Sportsman with cognome, rank and DataDiscirzione in this case i make it but 
	 * you can ask to the client to put the date
	 * */
	public Sportivo(String cognome,int rank,Date dataDiscrizione){
		setCognome(cognome);
		setRank(rank);
		setDataDiscrizione(dataDiscrizione);
	}
	/**
	 * Constructor who Initializes Sportsman with cognome, rank.
	 * dataDiiscirzione be Initializes by the program and the client couldn't
	 * */
	public Sportivo(String cognome,int rank){
		setCognome(cognome);
		setRank(rank);
		setDataDiscrizione(new Date());
	}
	/**
	 * Here we make a control about the String cognome, if it is shorter than 3 char or contain a number
	 * we set it with the "$" 
	 * */
	public void setCognome(String cognome) {
		Pattern pattern = Pattern.compile("\\d");
		if(cognome.length()<3||pattern.matcher(cognome).find()) {
			this.cognome="$";
		}else {
			this.cognome=cognome;
		}
	}
	/**
	 * If cognome is "$" the function return cognome with $ and we'will use it in the main 
	 * */
	public String getCognome() {
		if(cognome=="$") {
			return cognome;
		}else {
			return cognome;
		}
		
	}
	protected int getRank() {
		return rank;
	}
	/**
	 * Here we set the Rank of a Sportsman. 
	 * If the rank is under 1 or over 30 we apply the default number (0)
	 * */
	public void setRank(int rank) {
		if(rank<0||rank>30) {
			this.rank=0;
		}else {
			this.rank = rank;
		}
	}
	/**
	 * Here we format the Date with the European format "dd/MM/yyyy"
	 * and return the format (String)
	 * */
	public String getDataDiscrizione() {
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
		formato=formatoData.format(dataDiscrizione);
		return formato;
	}
	/**
	 * Here we control if the date is null and in this case we set it null, (if you want you can have another approach)
	 *  
	 * */
	public void setDataDiscrizione(Date dataDiscrizione) {
		Optional<Date> optionDate = Optional.ofNullable(dataDiscrizione);
		
		if(optionDate.isEmpty()) {
			this.dataDiscrizione=null;
		}else {
			this.dataDiscrizione=dataDiscrizione;
		}
		
	}
	/**
	 * Here we transform the number rank in a letter from A to D
	 * 
	 * rank[1-10]  letter: A
	 * rank[11-20] letter: B
	 * rank[21-30]  letter: C
	 * rank[0] letter: D
	 * 
	 * */
	public char getLetterRanking() {
		char LetterRanking=' ';
		if(getCognome().equals("$")) {
			LetterRanking='$';
		}else {
		
		int controllo=getRank();
		
		if(controllo>=1&&controllo<=10) {
			 LetterRanking='A';
		}else if(rank>=11&&rank<=20) {
			 LetterRanking='B';
		}else if(rank>=21&&rank<=30) {
			 LetterRanking='C';
		}else {
			 LetterRanking='D';
		}
		}
		return LetterRanking;
		
	}
	
}
