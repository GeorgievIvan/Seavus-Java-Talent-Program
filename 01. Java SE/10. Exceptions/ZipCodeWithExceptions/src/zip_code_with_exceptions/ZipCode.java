package zip_code_with_exceptions;

class ZipCode {
	
	private String zipCode;
	
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
	
	public String getZipCode() {
		
		return zipCode;
	}
}
