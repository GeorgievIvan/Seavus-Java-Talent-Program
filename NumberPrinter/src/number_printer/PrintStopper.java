package number_printer;

class PrintStopper extends Thread {

	private final long timeInterval;

	private final NumberPrinter numberPrinter;
	
	public PrintStopper(final long timeInterval, final NumberPrinter numberPrinter) {
		
		this.timeInterval = timeInterval;
		
		this.numberPrinter = numberPrinter;
	}
	
	@Override
	public void run() {
		
		System.out.println(String.format("PrintStopper is now going to sleep for %d ms.", timeInterval));
		
		try {
			
			Thread.sleep(timeInterval);
		}
		catch(InterruptedException interruptedException) {
			
			System.err.println("PrintStopper was interrupted.");
		}
		
		System.out.println("PrintStopper will now interrupt NumberPrinter.");
		
		numberPrinter.interrupt();
	}
}
