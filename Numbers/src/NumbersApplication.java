/**
 * This is the main class for this exercise.
 * @author Ivan Georgiev
 *
 */
public class NumbersApplication {
	
	/**
	 * Used to convert the word representatives of the digits to {@code int} representatives.
	 * @param words An array that contains the word representatives of the digits.
	 * @return An array that contains the {@code int} representatives of the digits.
	 * @throws NullPointerException Thrown if {@code words} equals {@code null}. It will be also rethrown from {@link WordToIntDigitConvertor#convertWordToIntDigit(String) convertWordToIntDigit(String)}.
	 * @throws WordToIntConversionException Rethrown from {@link WordToIntDigitConvertor#convertWordToIntDigit(String) convertWordToIntDigit(String)}.
	 */
	public static int[] convertWordsToIntDigits(String []words) throws NullPointerException, WordToIntConversionException {
		
		if(words == null) {
			
			throw new NullPointerException("words equals null.");
		}
		
		int []digits = new int[words.length];

		for(int i = 0; i < words.length; ++i) {
			
			try {
			
				digits[i] = WordToIntDigitConvertor.convertWordToIntDigit(words[i]);
			}
			catch(NullPointerException nullPointerException) {
				
				throw nullPointerException;
			}
			catch(WordToIntConversionException wordToIntConversionException) {
				
				throw wordToIntConversionException;
			}
		}

		return digits;
	}
	
	/**
	 * Creates an natural number using an array of digits.
	 * @param digits An array that contains the digits.
	 * @return An natural number.
	 * @throws NullPointerException Rethrown from {@link NaturalNumber#appendDigits(int[]) appendDigits(int[])}.
	 * @throws IllegalArgumentException Rethrown from {@link NaturalNumber#appendDigits(int[]) appendDigits(int[])}.
	 */
	public static NaturalNumber createNaturalNumber(int []digits) throws NullPointerException, IllegalArgumentException {

		NaturalNumber naturalNumber = new NaturalNumber();
		
		try {
		
			naturalNumber.appendDigits(digits);
			
		}
		catch(NullPointerException nullPointerException) {
			
			throw nullPointerException;
		}
		catch(IllegalArgumentException illegalArgumentException) {
			
			throw illegalArgumentException;
		}
		
		return naturalNumber;
	}
	
	/**
	 * Prints the natural number.
	 * @param naturalNumber The natural number to be printed.
	 * @throws NullPointerException Thrown if {@code naturalNumber} equals {@code null}.
	 */
	public static void printNaturalNumber(NaturalNumber naturalNumber) throws NullPointerException {
		
		if(naturalNumber == null) {
			
			throw new NullPointerException("naturalNumber equals null.");
		}
		
		System.out.println(naturalNumber);
	}


	public static void main(String []arguments) {
		
		int []digits = null;
		NaturalNumber naturalNumber = null;
		
		try {
		
			digits = convertWordsToIntDigits(arguments);
		
		}
		catch(NullPointerException nullPointerException) {
			
			nullPointerException.printStackTrace();
			
			return;
		}
		catch(WordToIntConversionException wordToIntConversionException) {
			
			wordToIntConversionException.printStackTrace();
			
			return;
		}
		
		try {
		
			naturalNumber = createNaturalNumber(digits);
			
		}
		catch(NullPointerException nullPointerException) {
			
			nullPointerException.printStackTrace();
			
			return;
		}
		catch(IllegalArgumentException illegalArgumentException) {
			
			illegalArgumentException.printStackTrace();
			
			return;
		}
		
		try {
			
			printNaturalNumber(naturalNumber);
		}
		catch(NullPointerException nullPointerException) {
			
			System.out.println(nullPointerException);
		}
	}
}