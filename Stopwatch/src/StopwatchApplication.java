import java.util.Scanner;

/**
 * This is the main class for this exercise.
 * @author Ivan Georgiev
 *
 */
public class StopwatchApplication {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Stopwatch stopwatch = new Stopwatch();
				
		while(true) {
			
			String command = scanner.nextLine();
			
			try {
			
				switch(command) {
				
					case "start":
						stopwatch.startStopwatch();
					break;
					
					case "stop":
						stopwatch.stopStopwatch();
						
						scanner.close();
						
						return;
					
					case "pause":
						stopwatch.pauseStopwatch();
					break;
					
					case "resume":
						stopwatch.resumeStopwatch();
					break;
											
					default:
						System.out.println("Invalid command.");
				}
			}
			catch(IllegalStopwatchStateTransitionException illegalStopwatchStateTransitionException) {
				
				System.out.println(illegalStopwatchStateTransitionException.getMessage());
			}
		}
	}

}
