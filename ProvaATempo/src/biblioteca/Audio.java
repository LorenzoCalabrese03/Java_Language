package biblioteca;

public class Audio extends ElementoMultimediale {
	int bitrate;
	
	public Audio(String codice, String titolo, int durata,TipoFileMultimediale tipo , int bitrate) {
		super(codice, titolo, durata, tipo);
		this.bitrate=bitrate;
		// TODO Auto-generated constructor stub
	}

	public int getBitrate() {
		return bitrate;
	}

	public void setBitrate(int bitrate) {
		this.bitrate = bitrate;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+"Bitrate: "+bitrate;
	}

}
