package improved_word_counter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;;

public class ImprovedWordCounter {
	
	private HashMap<String, Integer> hashMap;
	
	public ImprovedWordCounter() {
	
		hashMap = new HashMap<String, Integer>();
	}

	public void countWord(String word) {
		
		word = StringUtils.lowerCase(word);
		
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
