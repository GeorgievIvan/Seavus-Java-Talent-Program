public class ZipCode {
	
	private String zipCode;
			
	public void setZipCode(String zipCode) throws ZipCodeContentException, ZipCodeLengthException, NullPointerException {
		
		if(zipCode == null) {
			
			throw new NullPointerException("zipCode is null");
		}
		
		if(zipCode.length() != 5 && zipCode.length() != 9) {
		
			throw new ZipCodeLengthException(zipCode);
		}
			
		for(int i = 0; i < zipCode.length(); ++i) {
			
			if(!Character.isDigit(zipCode.charAt(i))) {
					
				throw new ZipCodeContentException(zipCode);
			}
		}
			
		this.zipCode = zipCode;
	}
	
	public String getZipCode() {
		
		return zipCode;
	}
	
	public static void main(String[] args) {
		
		String string = "123456";
		
		ZipCode zipCode = new ZipCode();
		
		try {
		
			zipCode.setZipCode(string);
			
			System.out.println(String.format("The zip code is %s", zipCode.getZipCode()));
			
		}catch(ZipCodeLengthException zipCodeLengthException) {
			
			System.out.println(zipCodeLengthException.getMessage());
		}
		catch(ZipCodeContentException zipCodeContentException) {
			
			System.out.println(zipCodeContentException.getMessage());
		}
		catch(NullPointerException nullPointerException) {
			
			System.out.println(nullPointerException.getMessage());
		}
	}
}
