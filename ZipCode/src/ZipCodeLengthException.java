public class ZipCodeLengthException extends RuntimeException {

	public ZipCodeLengthException() {
		
	}
	
	public ZipCodeLengthException(String zipCode) {
		
		super(String.format("The length of \"%s\" is not valid for a zip code", zipCode));
	}
}