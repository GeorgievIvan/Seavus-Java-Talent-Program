package numbers;

public class NumbersApplication {
	
	public static void main(String []arguments) {
		
		NaturalNumber naturalNumber = new NaturalNumber();
		
		for(final String word : arguments) {
			
			try {
			
				final int digit = WordToIntDigitConvertor.convertWordToIntDigit(word);
				
				naturalNumber.appendDigit(digit);
			}
			catch(WordToIntDigitConversionException wordToIntDigitConversionException) {
				
				System.err.println(wordToIntDigitConversionException.getMessage());
				
				return;
			}
		}
		
		System.out.println(naturalNumber.getValue());
	}
}