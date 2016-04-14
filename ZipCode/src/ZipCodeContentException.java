/**
 * An exception that should be thrown when the content of the ZIP code is invalid.
 * @author Ivan Georgiev
 */
public class ZipCodeContentException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Calls the {@link java.lang.Exception#Exception(String) Exception(String)} constructor.
	 * @param zipCode The invalid ZIP code.
	 */
	public ZipCodeContentException(String invalidZipCode) {
		
		super(String.format("The content of \"%s\" is not valid for a zip code", invalidZipCode));
	}
}
