/**
 * The main class for this exercise.
 * @author Ivan Georgiev
 *
 */
public class NumberPrinterApplication {

	/**
	 * The upper limit up to which the {@link NumberPrinter NumberPrinter} should print.
	 */
	private static int upperLimit;
	
	/**
	 * The time interval in milliseconds after which the {@link NumberPrinter NumberPrinter} is to be interrupted by the {@link PrintStopper PrintStopper}.
	 */
	private static long timeInterval;
	
	/**
	 * Sets the upper limit and time interval.
	 * @param args The command line arguments.
	 * @throws IllegalArgumentException Thrown if the number of command line arguments is different than two.
	 * @throws NumberFormatException Thrown if the format of the command line arguments is incorrect.
	 */
	private static void readCommandLineInput(String[] args) throws IllegalArgumentException, NumberFormatException {
		
		if(args.length != 2) {
			
			throw new IllegalArgumentException("You must specify exactly two command line arguments.");
		}
		
		try {
			
			upperLimit = Integer.parseInt(args[0]);
		}
		catch(NumberFormatException numberFormatException) {
			
			System.err.println(String.format("%s cannot be converted to an int.", args[0]));
			
			throw numberFormatException;
		}
		
		try {
			
			timeInterval = Long.parseLong(args[1]);
		}
		catch(NumberFormatException numberFormatException) {
			
			System.err.println(String.format("%s cannot be converted to a long.", args[1]));
			
			throw numberFormatException;
		}
	}
	
	public static void main(String[] args) {
		
		try {
		
			readCommandLineInput(args);
		}
		catch(Exception exception) {
			
			exception.printStackTrace();
			
			return;
		}
				
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
			
			interruptedException.printStackTrace();
		}
		
		System.out.println(String.format("Upper limit: %d.", upperLimit));
		System.out.println(String.format("Time interval: %d milliseconds.", timeInterval));
	}
}
