package zip_code_with_exceptions;

public class ZipCodeLengthException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ZipCodeLengthException(String invalidZipCode) {
		
		super(String.format("The length of \"%s\" is not valid for a zip code.", invalidZipCode));
	}
}