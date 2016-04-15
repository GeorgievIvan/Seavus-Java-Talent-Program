import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * The main calss for this exercise.
 * @author Ivan Georgiev
 *
 */
public class MaxResultApplication {
	
	/**
	 * The number of complex calculations to be submitted.
	 */
    private static final int NUMBER_OF_COMPLEX_CALCULATIONS = 10;
	
    /**
     * Submits the complex calculations.
     * @param executorService The {@code ExecutorService} that will manage the threads.
     * @return The results from the calculations.
     */
    private static Future<Integer> []submitComplexCalculations(final ExecutorService executorService) {
    
		final Future<Integer> []complexCalculationResults = new Future[NUMBER_OF_COMPLEX_CALCULATIONS];
		
		for(int i = 0; i < NUMBER_OF_COMPLEX_CALCULATIONS; ++i) {
			
			final ComplexCalculation complexCalculation = new ComplexCalculation(i);
						
			complexCalculationResults[i] = executorService.submit(complexCalculation);
		}
		
		return complexCalculationResults;
    }
    
    /**
     * Calculates the maximum value from the complex calculations.
     * <br>
     * This method will block if any of the complex calculations are not finished.
     * @param complexCalculationResults The results from the complex calculations.
     * @return the maximum value from the complex calculations.
     */
    private static Integer calculateMaximum(final Future<Integer> []complexCalculationResults) {
    	
    	Integer maximum = null;
    	
        for(int i = 0; i < complexCalculationResults.length; ++i) {
        	
        	try {
        		
				final Integer result = complexCalculationResults[i].get();
				
				System.out.println(String.format("Complex calculation %d returned %d.", i, result));
				
				if(maximum == null) {
					
					maximum = result;
					
					continue;
				}
				
				if(result > maximum) {
					
					maximum = result;
				}
			}
        	catch(InterruptedException e) {

				e.printStackTrace();
			}
        	catch(ExecutionException e) {

				e.printStackTrace();
			}
        }
        
        System.out.println("All complex calculations have finished.");
    	
    	return maximum;
    }
    
	public static void main(String[] args) {
		
        final ExecutorService executorService = Executors.newCachedThreadPool();
        
		final Future<Integer> []complexCalculationResults = submitComplexCalculations(executorService);
		
        final Integer maximum = calculateMaximum(complexCalculationResults);
        
        executorService.shutdown();
        
        System.out.println(String.format("The maximum is %d.", maximum));
	}
}
