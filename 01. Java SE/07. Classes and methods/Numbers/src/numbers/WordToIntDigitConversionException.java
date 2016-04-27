package numbers;

public class WordToIntDigitConversionException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public WordToIntDigitConversionException(final String word) {
		
		super(String.format("\"%s\" is not a valid word for a digit.", word));
	}

}
