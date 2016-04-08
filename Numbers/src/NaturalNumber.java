/**
 * A class used to represent a natural number.
 * @author Ivan Georgiev
 *
 */
class NaturalNumber {
	
	/**
	 * An instance variable that holds the value of the natural number.
	 */
	private int value;
	
	/**
	 * Appends an array of digits to the value of the natural number.
	 * The first digit to be appended is the one at index 0 in the array.
	 * @param digits An {@code int} array that contains the digits to be appended to the value of the natural number.
	 * @throws NullPointerException This exception is thrown if {@code digits} equals {@code null}.
	 * @throws IllegalArgumentException This exception is thrown if at least one element in {@code digits} is not a valid digit.
	 * Valid digits are {@code int} numbers in the range [0-9].
	 */
	public void appendDigits(int []digits) throws NullPointerException, IllegalArgumentException {
		
		if(digits == null) {
	
			throw new NullPointerException("digits equals null.");
		}
		
		for(int digit : digits) {

			if(digit < 0 || digit > 9) {

				throw new IllegalArgumentException();
			}
			
			value *= 10;

			value += digit;
		}
	}

	/**
	 * Returns the value of the natural number.
	 * @return An {@code int} that represents the value of the natural number.
	*/
	public int getValue() {

		return value;
	}

	@Override
	public String toString() {

		return Integer.toString(value);
	}
}