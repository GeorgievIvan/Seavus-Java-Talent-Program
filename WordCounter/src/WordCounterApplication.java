import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * The main class for this exercise.
 * @author Ivan Georgiev
 *
 */
public class WordCounterApplication {
	
	private static WordCounter wordCounter;
	
	/**
	 * Reads the file with the words and creates a {@link WordCounter WordCounter} to count the occurrence of each word.
	 * @param path The path to the file.
	 * @throws FileNotFoundException Thrown if the file is not found.
	 * @throws IOException Thrown if an {@link IOException IOException} occurs while working with the file.
	 */
	private static void readFile(String path) throws FileNotFoundException, IOException {
				
		File inputFile = new File(path);
		
		FileReader fileReader = new FileReader(inputFile);
		
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		wordCounter = new WordCounter();
		
		while(true) {
						
			String line = bufferedReader.readLine();
				
			if(line == null) {
				
				break;
			}
			
			String []fields = line.split(" ");
			
			for(String field : fields) {
				
				wordCounter.countWord(field);
			}
		}
			
		bufferedReader.close();
	}
	
	public static void main(String[] args) {
		
		if(args.length != 1) {
			
			System.out.println("You must specify the path of the input file");
			
			return;
		}
		
		try {
			
			readFile(args[0]);
			
		}
		catch(FileNotFoundException fileNotFoundException) {
			
			System.out.println(String.format("%s does not exist", args[0]));
			
			return;
		}
		catch(IOException ioException) {
			
			ioException.printStackTrace();
			
			return;
		}
		
		wordCounter.print();
	}
}
