/**
 * An exception that should be thrown when the length of the ZIP code is invalid.
 * @author Ivan Georgiev
 */
public class ZipCodeLengthException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Calls the {@link java.lang.Exception#Exception(String) Exception(String)} constructor.
	 * @param zipCode The invalid ZIP code.
	 */
	public ZipCodeLengthException(String invalidZipCode) {
		
		super(String.format("The length of \"%s\" is not valid for a zip code.", invalidZipCode));
	}
}