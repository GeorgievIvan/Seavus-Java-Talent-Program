/**
 * An exception that should be thrown when there is an attempt at an invalid conversion from a word representation of a digit to an {@code int} representation.
 * @author Ivan Georgiev
 *
 */
class WordToIntConversionException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	/**
	 * A parameterized constructor which in turn calls the {@link java.lang.Exception#Exception(String) Exception(String)} constructor from the {@link java.lang.Exception java.lang.Exception} class.
	 * @param word A {@link java.lang.String String} reference to a character string that represents the digit as a word.
	 */
	public WordToIntConversionException(String word) {
		
		super(String.format("\"%s\" is not a valid word for a digit.", word));
	}

}
