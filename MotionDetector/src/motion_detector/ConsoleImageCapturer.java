package motion_detector;

import java.util.Scanner;

public class ConsoleImageCapturer implements ImageCapturer {

	private final Scanner scanner;
	
	public ConsoleImageCapturer() {
		
		scanner = new Scanner(System.in);
	}
	
	public String captureImage() {
		
		String image = scanner.nextLine();
		
		return image;
	}
}
