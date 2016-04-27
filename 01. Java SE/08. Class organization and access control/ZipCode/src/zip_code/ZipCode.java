package zip_code;

class ZipCode {
	
	private String zipCode;
	
	public void setZipCode(String newZipCode) {
		
		if(newZipCode.length() == 5 || newZipCode.length() == 9) {
		
			zipCode = newZipCode;
		}
	}
	
	public String getZipCode() {
		
		return zipCode;
	}
}
