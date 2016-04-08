/**
 * A class used to convert a word representative of a digit to an int representative of that digit.
 * @author Ivan Georgiev
 *
 */
class WordToIntDigitConvertor {
	
		/**
		 * Converts a word representative of a digit to an {@code int} representative of that digit.
		 * @param word A {@link java.lang.String String} reference to a character string that represents the digit as a word.
		 * @return An {@code int} with a value in the range [0-9].
		 * @throws NullPointerException This exception is thrown if {@code word} equals {@code null}.
		 * @throws WordToIntConversionException This exception is thrown if {@code word} references a character string that is not a valid word for a digit.
		 * Valid words for digits are: "one", "two", "three", "four", "five", "six", "seven", "eight" and "nine".
		*/
	static public int convertWordToIntDigit(String word) throws NullPointerException, WordToIntConversionException {
		
		if(word == null) {
			
			throw new NullPointerException();
		}
		
		int digit;
		
		switch(word) {

			case "zero":
				digit = 0;
			break;

			case "one":
				digit = 1;
			break;

			case "two":
				digit = 2;
			break;

			case "three":
				digit = 3;
			break;

			case "four":
				digit = 4;
			break;

			case "five":
				digit = 5;
			break;

			case "six":
				digit = 6;
			break;

			case "seven":
				digit = 7;
			break;

			case "eight":
				digit = 8;
			break;

			case "nine":
				digit = 9;
			break;

			default:
				throw new WordToIntConversionException(word);
		}

		return digit;
	}
}
