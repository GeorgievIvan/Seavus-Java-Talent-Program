package motion_detector.alarm_channels;

public class ConsoleAlarmChannel implements AlarmChannel {
	
	@Override
	public void alarm() {
	
		System.out.println("Beep.");
	}
}
