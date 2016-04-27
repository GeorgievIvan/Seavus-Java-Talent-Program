package max_result;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MaxResultApplication {
	
    private static final int NUMBER_OF_COMPLEX_CALCULATIONS = 10;
	
    private static Future<Integer> []submitComplexCalculations(final ExecutorService executorService) {
    
		final Future<Integer> []complexCalculationResults = new Future[NUMBER_OF_COMPLEX_CALCULATIONS];
		
		for(int i = 0; i < NUMBER_OF_COMPLEX_CALCULATIONS; ++i) {
			
			final ComplexCalculation complexCalculation = new ComplexCalculation(i);
						
			complexCalculationResults[i] = executorService.submit(complexCalculation);
		}
		
		return complexCalculationResults;
    }
    
    private static Integer calculateMaximum(final Future<Integer> []complexCalculationResults) throws InterruptedException, ExecutionException {
    	
    	Integer maximum = null;
    	
        for(int i = 0; i < complexCalculationResults.length; ++i) {
        	
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
        
        System.out.println("All complex calculations have finished.");
    	
    	return maximum;
    }
    
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
        final ExecutorService executorService = Executors.newCachedThreadPool();
        
		final Future<Integer> []complexCalculationResults = submitComplexCalculations(executorService);
		
        final Integer maximum = calculateMaximum(complexCalculationResults);
        
        executorService.shutdown();
        
        System.out.println(String.format("The maximum is %d.", maximum));
	}
}
