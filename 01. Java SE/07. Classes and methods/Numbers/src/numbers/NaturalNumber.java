package numbers;

public class NaturalNumber {
	
	private int value;
	
	public void appendDigit(final int digit) throws IllegalArgumentException {
		
		if(digit < 0 || digit > 9) {

			throw new IllegalArgumentException(String.format("\"%d\" is not a digit.", digit));
		}
			
		value *= 10;

		value += digit;
	}
	
	public int getValue() {

		return value;
	}
}