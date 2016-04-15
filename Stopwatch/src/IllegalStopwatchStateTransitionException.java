/**
 * This exception should be thrown when there is an attempt at an illegal state transition for the stopwatch.
 * @author Ivan Georgiev
 *
 */
class IllegalStopwatchStateTransitionException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Calls the {@link RuntimeException#RuntimeException(String) RuntimeException(String)} constructor.
	 * @param message The detail message.
	 */
	public IllegalStopwatchStateTransitionException(String message) {
		
		super(message);
	}
}
