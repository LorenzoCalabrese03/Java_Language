package dizionario;

public class Coppia {
	Object key;
	Object value;
	
	public Coppia(Object key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}
	public Object getKey() {
		return key;
	}
	public void setKey(Object key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Coppia [key=" + key + ", value=" + value + "]";
	}
	
	
}
