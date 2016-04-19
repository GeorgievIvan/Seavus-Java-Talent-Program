import motion_detector.ImageCapturer;
import motion_detector.ConsoleImageCapturer;
import motion_detector.AlarmChannel;
import motion_detector.ConsoleAlarmChannel;
import motion_detector.MotionDetector;

public class MotionDetectorApplication {

	public static void main(String []args) {
		
		ImageCapturer imageCapturer = new ConsoleImageCapturer();
		AlarmChannel alarmChannel = new ConsoleAlarmChannel();
		
		MotionDetector motionDetector = new MotionDetector(imageCapturer);
		motionDetector.registerAlarmChannel(alarmChannel);
		
		motionDetector.runMotionDetector();
	}
}
