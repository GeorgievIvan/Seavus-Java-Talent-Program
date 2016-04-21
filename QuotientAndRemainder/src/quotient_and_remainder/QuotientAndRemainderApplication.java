package quotient_and_remainder;

public class QuotientAndRemainderApplication {

	public static void main(String[] args) {

		final int number1 = 10;
		final int number2 = 4;
		
		final int quotient = number1 / number2;
		final int remainder = number1 % number2;
		
		System.out.println(String.format("number1: %d", number1));
		System.out.println(String.format("number2: %d", number2));
		System.out.println(String.format("quotient: %d\tremainder: %d", quotient, remainder));
	}
}
