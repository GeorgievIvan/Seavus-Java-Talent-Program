/**
 * This class represents the stopwatch.
 * @author Ivan Georgiev
 *
 */
class Stopwatch extends Thread {

	/**
	 * This enumeration represents the states that the stopwatch can be in.
	 * @author Ivan Georgiev
	 *
	 */
	enum StopwatchState {
		
		RUNNING, STOPPED, PAUSED
	}
	
	/**
	 * The stopwatch's counter.
	 */
	private int counter;
	
	/**
	 * The stopwatch's state.
	 */
	private StopwatchState stopwatchState;
	
	/**
	 * Initializes the stopwatch's counter and state.
	 */
	public Stopwatch() {
		
		counter = 0;
		
		stopwatchState = StopwatchState.STOPPED;
	}
	
	/**
	 * Starts the stopwatch.
	 * @throws IllegalStopwatchStateTransitionException Thrown if the stopwatch's state is not {@code STOPPED}.
	 */
	public void startStopwatch() throws IllegalStopwatchStateTransitionException {
		
		if(stopwatchState != StopwatchState.STOPPED) {
			
			throw new IllegalStopwatchStateTransitionException("The stopwatch has to be stopped in order to be started.");
		}
		
		stopwatchState = StopwatchState.RUNNING;
		
		start();
	}
	
	/**
	 * Stops the stopwatch.
	 * @throws IllegalStopwatchStateTransitionException Thrown if the stopwatch's state is not {@code RUNNING} or {@code PAUSED}.
	 */
	public void stopStopwatch() {
		
		if(stopwatchState != StopwatchState.RUNNING && stopwatchState != StopwatchState.PAUSED) {
			
			throw new IllegalStopwatchStateTransitionException("The stopwatch has to be running or paused in order to be stoped.");
		}
		
		stopwatchState = StopwatchState.STOPPED;
		
		interrupt();
	}
	
	/**
	 * Pauses the stopwatch.
	 * @throws IllegalStopwatchStateTransitionException Thrown if the stopwatch's state is not {@code RUNNING}.
	 */
	public void pauseStopwatch() {
		
		if(stopwatchState != StopwatchState.RUNNING) {
			
			throw new IllegalStopwatchStateTransitionException("The stopwatch has to be running in order to be paused.");
		}
		
		stopwatchState = StopwatchState.PAUSED;
		
		interrupt();
	}
	
	/**
	 * Resumes the stopwatch.
	 * @throws IllegalStopwatchStateTransitionException Thrown if the stopwatch's state is not {@code PAUSED}.
	 */
	public void resumeStopwatch() {
		
		if(stopwatchState != StopwatchState.PAUSED) {
			
			throw new IllegalStopwatchStateTransitionException("The stopwatch has to be paused in order to be resumed.");
		}
		
		stopwatchState = StopwatchState.RUNNING;
		
		synchronized(this) {
		
			notifyAll();
		}
	}
	
	/**
	 * This method prints every passing second unless the stopwatch is paused.
	 * <br>
	 * The method returns when the stopwatch is stopped.
	 */
	@Override
	public void run() {
		
		while(true) {
			
			if(interrupted()) {
				
				switch(stopwatchState) {
				
					case STOPPED:
						return;

					case PAUSED:
						try {
							
							synchronized(this) {
								
								wait();
							}
						}
						catch (InterruptedException interruptedException) {
							
							if(stopwatchState == StopwatchState.STOPPED) {
								
								return;
							}
							
							interruptedException.printStackTrace();
						}
					break;
				}
			}
			
			counter += 1;
			System.out.println(counter);
			
			try {
				
				sleep(1000);
			}
			catch (InterruptedException interruptedException1) {

				switch(stopwatchState) {
				
					case STOPPED:
						return;
	
					case PAUSED:
						try {
							
							synchronized(this) {
								
								wait();
							}
						}
						catch (InterruptedException interruptedException2) {
	
							if(stopwatchState == StopwatchState.STOPPED) {
								
								return;
							}
							
							interruptedException2.printStackTrace();
						}
					break;
					
					default:
						interruptedException1.printStackTrace();
				}
			}
		}
	}
}
