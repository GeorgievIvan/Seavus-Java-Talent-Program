package motion_detector;

public class ConsoleAlarmChannel implements AlarmChannel {
	
	@Override
	public void alarm() {
	
		System.out.println("Beep.");
	}
}
