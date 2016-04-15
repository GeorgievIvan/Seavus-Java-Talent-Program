import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * This class represents a complex calculation.
 * @author Ivan Georgiev
 *
 */
public class ComplexCalculation implements Callable <Integer> {

	/**
	 * The order number of the complex calculation.
	 */
	private final Integer orderNumber;
	
	
	/**
	 * Initializes the order number of the complex calculation.
	 * @param orderNumber The order number of the complex calculation.
	 */
	public ComplexCalculation(final Integer orderNumber) {
	 
		 this.orderNumber = orderNumber;
	}
	
	/**
	 * Performs the complex calculation.
	 * <br>
	 * This method puts the thread to sleep for 0-5 seconds and returns an integer in the range [0-100].
	 */
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
