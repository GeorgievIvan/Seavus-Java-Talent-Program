package zip_code;

public class ZipCodeContentException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ZipCodeContentException(String invalidZipCode) {
		
		super(String.format("The content of \"%s\" is not valid for a zip code", invalidZipCode));
	}
}
