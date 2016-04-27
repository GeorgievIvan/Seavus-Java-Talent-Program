package zip_code;

public class ZipCodeApplication {

	public static void main(String[] args) {
		
		String string = "12345";
		
		ZipCode zipCode = new ZipCode();
		
		zipCode.setZipCode(string);
			
		System.out.println(String.format("The ZIP code is: %s", zipCode.getZipCode()));
	}
}

