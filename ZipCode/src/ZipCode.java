/**
 * Used to represent a ZIP code.
 * @author Ivan Georgiev
 *
 */
class ZipCode {
	
	/**
	 * The ZIP code.
	 */
	private String zipCode;
	
	/**
	 * Used to set the ZIP code.
	 * @param newZipCode The new ZIP code.
	 * @throws NullPointerException Thrown if {@code newZipCode} equals {@code null}.
	 * @throws ZipCodeLengthException Thrown if the length of {@code newZipCode} is neither 5 nor 9.
	 * @throws ZipCodeContentException Thrown if {@code newZipCode} does not contain only digits.
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
	 * Returns the ZIP code.
	 * @return The ZIP code or null if the ZIP code has not been successfully set using the {@link ZipCode#setZipCode setZipCode()} method.
	 */
	public String getZipCode() {
		
		return zipCode;
	}
	
	@Override
	public String toString() {
		
		return String.format("The ZIP code is: %s", zipCode);
	}
}
