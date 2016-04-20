package improved_word_counter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;;

/**
 * Used to count the number of occurrence of each word ignoring the case. 
 * @author Ivan Georgiev
 *
 */
public class WordCounter {
	
	/**
	 * Used to store each word and the corresponding number of occurrences.
	 */
	private HashMap<String, Integer> hashMap;
	
	/**
	 * Initializes {@link WordCounter#hashMap}.
	 */
	public WordCounter() {
	
		hashMap = new HashMap<String, Integer>();
	}
	
	/**
	 * Used to count a word.
	 * @param word The word to be counted.
	 */
	public void countWord(String word) {
		
		word = StringUtils.lowerCase(word);
		
		Integer currentCount = hashMap.get(word);
		
		if(currentCount == null) {
			
			hashMap.put(word, 1);
			
			return;
		}
		
		hashMap.put(word, currentCount + 1);
	}
	
	/*
	 * Used to print each word and the corresponding number of occurrences.
	 */
	public void print() {
		
		Set <Map.Entry<String, Integer>> set = hashMap.entrySet();
		
		Iterator <Map.Entry<String, Integer>> iterator = set.iterator();
		
		while(iterator.hasNext()) {
			
			Map.Entry<String, Integer> entry = iterator.next();
			
			System.out.println(String.format("%s\t%d", entry.getKey(), entry.getValue()));
		}
	}
}
