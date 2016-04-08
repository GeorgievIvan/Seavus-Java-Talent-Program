/** A class intended to represent a ZIP code
 * @author Ivan Georgiev
 */
class ZipCode {
	
	/**
	 * A reference to a string of characters that represent the ZIP code.
	 */
	private String zipCode;
	
	/**
	 * A method used to set the value of the instance variable {@link ZipCode#zipCode zipCode}.
	 * @param newZipCode This is a reference to a string of characters that represent the new ZIP code.
	 * @throws NullPointerException This exception is thrown if newZipCode is equal to null.
	 * @throws ZipCodeLengthException This exception is thrown if newZipCode references a character string of length that is neither 5 nor 9.
	 * @throws ZipCodeContentException This exception is thrown if the character string referenced by newZipCode does not contain only digits.
	 */
	public void setZipCode(String newZipCode) throws NullPointerException, ZipCodeLengthException, ZipCodeContentException {
		
		if(newZipCode == null) {
			
			throw new NullPointerException("newZipCode is null");
		}
		
		if(newZipCode.length() != 5 && newZipCode.length() != 9) {
		
			throw new ZipCodeLengthException(newZipCode);
		}
			
		for(int i = 0; i < newZipCode.length(); ++i) {
			
			if(!Character.isDigit(newZipCode.charAt(i))) {
					
				throw new ZipCodeContentException(newZipCode);
			}
		}
			
		zipCode = newZipCode;
	}
	
	/**
	 * A method that returns a reference to the character string that represents the ZIP code.
	 * @return A {@link java.lang.String String} reference to the character string that represents the ZIP code or null if {@link ZipCode#zipCode zipCode} has not been successfully set using the {@link ZipCode#setZipCode setZipCode()} method.
	 */
	public String getZipCode() {
		
		return zipCode;
	}
	
	@Override
	public String toString() {
		
		return String.format("The ZIP code is: %s", zipCode);
	}
}
