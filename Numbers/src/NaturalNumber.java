/**
 * Used to represent a natural number.
 * @author Ivan Georgiev
 *
 */
class NaturalNumber {
	
	/**
	 * The value of the natural number.
	 */
	private int value;
	
	/**
	 * Appends an array of digits to the value of the natural number.
	 * The first digit to be appended is the one at index 0 in the array.
	 * @param digits The array that contains the digits to be appended to the value of the natural number.
	 * @throws NullPointerException Thrown if {@code digits} equals {@code null}.
	 * @throws IllegalArgumentException Thrown if at least one element in {@code digits} is not a valid digit.
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
	 * @return The value of the natural number.
	*/
	public int getValue() {

		return value;
	}

	@Override
	public String toString() {

		return Integer.toString(value);
	}
}