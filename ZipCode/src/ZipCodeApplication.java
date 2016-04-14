/**
 * The main class for this exercise.
 * @author Ivan Georgiev
 *
 */
public class ZipCodeApplication {

	public static void main(String[] args) {
		
		String string = "12345";
		
		ZipCode zipCode = new ZipCode();
		
		try {
		
			zipCode.setZipCode(string);
			
			System.out.println(zipCode);
			
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

