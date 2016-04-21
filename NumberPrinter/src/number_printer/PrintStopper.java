/**
 * Used to interrupt the {@link NumberPrinter NumberPrinter}.
 * @author Ivan Georgiev
 *
 */
class PrintStopper extends Thread {

	/**
	 * The time interval in milliseconds after which the {@link NumberPrinter NumberPrinter} is to be interrupted.
	 */
	private final long timeInterval;
	
	/**
	 * The {@code NumberPrinter} to be interrupted.
	 */
	private final NumberPrinter numberPrinter;
	
	/**
	 * Initializes the time interval and {@code NumberPrinter}.
	 * @param timeInterval The time interval.
	 * @param numberPrinter The {@code NumberPrinter}.
	 */
	public PrintStopper(final long timeInterval, final NumberPrinter numberPrinter) {
		
		this.timeInterval = timeInterval;
		
		this.numberPrinter = numberPrinter;
	}
	
	/**
	 * Puts the current thread to sleep for {@link PrintStopper#timeInterval timeInterval} milliseconds and interrupts the {@link NumberPrinter NumberPrinter} after waking up.
	 */
	@Override
	public void run() {
		
		System.out.println(String.format("PrintStopper is now going to sleep for %d ms.", timeInterval));
		
		try {
			
			Thread.sleep(timeInterval);
		}
		catch(InterruptedException interruptedException) {
			
			System.err.println("PrintStopper was interrupted.");
			
			interruptedException.printStackTrace();
		}
		
		System.out.println("PrintStopper will now interrupt NumberPrinter.");
		
		numberPrinter.interrupt();
	}
}
