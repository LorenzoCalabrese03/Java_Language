package Entity;

import java.util.Comparator;

public class SearchByCost implements Comparator<Immobile> {
	@Override
	public int compare(Immobile a, Immobile b) {
		
		return Double.compare(b.calcolaPrezzo(),a.calcolaPrezzo());
	}
}
