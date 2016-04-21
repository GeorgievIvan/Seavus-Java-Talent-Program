package stopwatch;

class IllegalStopwatchStateTransitionException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IllegalStopwatchStateTransitionException(String message) {
		
		super(message);
	}
}
