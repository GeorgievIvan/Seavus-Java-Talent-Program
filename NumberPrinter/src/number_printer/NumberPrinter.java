package number_printer;

class NumberPrinter extends Thread {

	private final int upperLimit;
	
	public NumberPrinter(final int upperLimit) {
		
		this.upperLimit = upperLimit;
	}

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
