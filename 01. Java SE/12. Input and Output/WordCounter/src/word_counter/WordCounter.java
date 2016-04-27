package word_counter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class WordCounter {
	
	private HashMap<String, Integer> hashMap;
	
	public WordCounter() {
	
		hashMap = new HashMap<String, Integer>();
	}

	public void countWord(String word) {
		
		word = word.toLowerCase();
		
		Integer currentCount = hashMap.get(word);
		
		if(currentCount == null) {
			
			hashMap.put(word, 1);
			
			return;
		}
		
		hashMap.put(word, currentCount + 1);
	}
	
	public void print() {
		
		Set <Map.Entry<String, Integer>> set = hashMap.entrySet();
		
		Iterator <Map.Entry<String, Integer>> iterator = set.iterator();
		
		while(iterator.hasNext()) {
			
			Map.Entry<String, Integer> entry = iterator.next();
			
			System.out.println(String.format("word:\t%s\noccurrences:\t%d\n", entry.getKey(), entry.getValue()));
		}
	}
}
