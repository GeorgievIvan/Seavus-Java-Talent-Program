package word_counter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class WordCounterApplication {
	
	public static void main(String[] args) throws IOException {
				
		File inputFile = new File(args[0]);
		FileReader fileReader = new FileReader(inputFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		WordCounter wordCounter = new WordCounter();
		
		while(true) {
			
			String line = null;
			
			try {
				
				line = bufferedReader.readLine();
			}
			catch(IOException ioException) {
				
				bufferedReader.close();
				
				throw ioException;
			}
			
			if(line == null) {
				
				break;
			}
			
			String []fields = line.split(" ");
			
			for(String field : fields) {
				
				wordCounter.countWord(field);
			}
		}
		
		bufferedReader.close();
		
		wordCounter.print();
	}
}
