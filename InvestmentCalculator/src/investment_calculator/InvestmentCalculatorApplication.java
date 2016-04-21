package investment_calculator;

public class InvestmentCalculatorApplication {

	public static void main(String[] args) {

		final int investment = 14000;
		
		final int valueAfterFirstYear = investment + ((investment / 100) * 40);
		final int valueAfterSecondYear = valueAfterFirstYear - 1500;
		final int valueAfterThirdYear = valueAfterSecondYear + ((valueAfterSecondYear / 100) * 12);
		
		System.out.println(String.format("investment: %d", investment));
		System.out.println(String.format("value after first year: %d", valueAfterFirstYear));
		System.out.println(String.format("value after second year: %d", valueAfterSecondYear));
		System.out.println(String.format("value after third year: %d", valueAfterThirdYear));
	}
}
