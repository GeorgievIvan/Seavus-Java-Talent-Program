/**
 * An exception that should be thrown when the content of the ZIP code is invalid.
 * @author Ivan Georgiev
 */
public class ZipCodeContentException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	/**
	 * A parameterized constructor which in turn calls the {@link java.lang.Exception#Exception(String message) Exception(String message)} constructor from the {@link java.lang.Exception java.lang.Exception} class.
	 * @param zipCode a String reference to a character string that represents the ZIP code.
	 */
	public ZipCodeContentException(String zipCode) {
		
		super(String.format("The content of \"%s\" is not valid for a zip code", zipCode));
	}
}
