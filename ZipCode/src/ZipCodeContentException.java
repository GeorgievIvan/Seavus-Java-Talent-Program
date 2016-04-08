public class ZipCodeContentException extends RuntimeException {

	public ZipCodeContentException() {
		
	}
	
	public ZipCodeContentException(String zipCode) {
		
		super(String.format("The content of \"%s\" is not valid for a zip code", zipCode));
	}
}
