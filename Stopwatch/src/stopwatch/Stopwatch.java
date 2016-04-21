package stopwatch;

class Stopwatch extends Thread {

	enum StopwatchState {
		
		RUNNING, STOPPED, PAUSED
	}
	
	private int counter;

	private StopwatchState stopwatchState;
	
	public Stopwatch() {
		
		counter = 0;
		
		stopwatchState = StopwatchState.STOPPED;
	}
	
	public void startStopwatch() throws IllegalStopwatchStateTransitionException {
		
		if(stopwatchState != StopwatchState.STOPPED) {
			
			throw new IllegalStopwatchStateTransitionException("The stopwatch has to be stopped in order to be started.");
		}
		
		stopwatchState = StopwatchState.RUNNING;
		
		start();
	}
	
	public void stopStopwatch() throws IllegalStopwatchStateTransitionException {
		
		if(stopwatchState != StopwatchState.RUNNING && stopwatchState != StopwatchState.PAUSED) {
			
			throw new IllegalStopwatchStateTransitionException("The stopwatch has to be running or paused in order to be stoped.");
		}
		
		stopwatchState = StopwatchState.STOPPED;
		
		interrupt();
	}
	
	public void pauseStopwatch() throws IllegalStopwatchStateTransitionException {
		
		if(stopwatchState != StopwatchState.RUNNING) {
			
			throw new IllegalStopwatchStateTransitionException("The stopwatch has to be running in order to be paused.");
		}
		
		stopwatchState = StopwatchState.PAUSED;
		
		interrupt();
	}
	
	public void resumeStopwatch() throws IllegalStopwatchStateTransitionException {
		
		if(stopwatchState != StopwatchState.PAUSED) {
			
			throw new IllegalStopwatchStateTransitionException("The stopwatch has to be paused in order to be resumed.");
		}
		
		stopwatchState = StopwatchState.RUNNING;
		
		synchronized(this) {
		
			notifyAll();
		}
	}
	
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
						catch(InterruptedException interruptedException) {
							
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
			catch(InterruptedException interruptedException1) {

				switch(stopwatchState) {
				
					case STOPPED:
						return;
	
					case PAUSED:
						try {
							
							synchronized(this) {
								
								wait();
							}
						}
						catch(InterruptedException interruptedException2) {
	
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
