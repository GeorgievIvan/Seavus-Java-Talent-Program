package max_result;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ComplexCalculation implements Callable <Integer> {

	private final Integer orderNumber;
	
	public ComplexCalculation(final Integer orderNumber) {
	 
		 this.orderNumber = orderNumber;
	}

	@Override
	public Integer call() {
		
		final Random random = new Random();
		
        final Integer result = random.nextInt(100) + 1;
		
        System.out.println(String.format("Complex calculation %d started.", orderNumber));
        
        try {
        	
        	final long sleepTime = random.nextInt(5) + 1;
        	        	
            TimeUnit.SECONDS.sleep(sleepTime);
        }
        catch(InterruptedException interruptedException) {
        	        	
        	interruptedException.printStackTrace();
        }
        
        System.out.println(String.format("Complex calculation %d completed.", orderNumber));
		
		return result;
	}
}
