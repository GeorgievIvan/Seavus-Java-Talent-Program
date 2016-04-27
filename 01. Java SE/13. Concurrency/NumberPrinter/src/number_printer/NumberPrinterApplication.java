package number_printer;

public class NumberPrinterApplication {

	public static void main(String[] args) {

		final int upperLimit = Integer.parseInt(args[0]);
		final long timeInterval = Integer.parseInt(args[1]);
		
		NumberPrinter numberPrinter = new NumberPrinter(upperLimit);
		PrintStopper printStopper = new PrintStopper(timeInterval, numberPrinter);
		
		printStopper.start();
		numberPrinter.start();
		
		try {
			
			printStopper.join();
			numberPrinter.join();
		}
		catch (InterruptedException interruptedException) {

			System.err.println("Main was interrupted.");
		}
		
		System.out.println(String.format("Upper limit: %d.", upperLimit));
		System.out.println(String.format("Time interval: %d milliseconds.", timeInterval));
	}
}
