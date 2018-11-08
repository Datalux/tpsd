import java.util.Map;
import java.util.HashMap;

public class ShowList{
	private Map series;

	ShowList(){
		series = new HashMap();
		series.put("House of Karts",5);
		series.put("Strange Things", 10);
		series.put("Baking Brad", 12);
		series.put("Marcos", 7);
		series.put("Black Mails", 15);
		series.put("Rick e Morto", 4);
	}

	public boolean isAvaible(String name, int n){
		return series.containsKey(name) && ((int)series.get(name) >= n);
	}

	
}