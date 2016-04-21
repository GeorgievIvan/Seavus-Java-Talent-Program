package zip_code;

public class ZipCodeApplication {

	public static void main(String[] args) {
		
		String string = "12345";
		
		ZipCode zipCode = new ZipCode();
		
		try {
		
			zipCode.setZipCode(string);
			
			System.out.println(String.format("The ZIP code is: %s", zipCode.getZipCode()));
			
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

