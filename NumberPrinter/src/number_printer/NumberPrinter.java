/**
 * Used to print numbers up to a specified limit in a separate thread.
 * @author Ivan Georgiev
 *
 */
class NumberPrinter extends Thread {

	/**
	 * The upper limit.
	 */
	private final int upperLimit;
	
	/**
	 * Initializes the upper limit.
	 * @param upperLimit The upper limit.
	 */
	public NumberPrinter(final int upperLimit) {
		
		this.upperLimit = upperLimit;
	}
	
	/**
	 * Prints all the {@code int} numbers in the range [1, {@link NumberPrinter#upperLimit upperLimit}] or until interrupted.
	 */
	@Override
	public void run() {
		
		for(int i = 1; i <= upperLimit; ++i) {
			
			if(Thread.interrupted()) {
				
				System.out.println("NumberPrinter was interrupted.");
				
				return;
			}
			
			System.out.println(i);
		}
	}
}
