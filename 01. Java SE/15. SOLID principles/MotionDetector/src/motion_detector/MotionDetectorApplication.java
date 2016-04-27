package motion_detector;

import motion_detector.alarm_channels.AlarmChannel;
import motion_detector.alarm_channels.ConsoleAlarmChannel;
import motion_detector.image_capturers.ConsoleImageCapturer;
import motion_detector.image_capturers.ImageCapturer;
import motion_detector.motion_detectors.MotionDetector;

public class MotionDetectorApplication {

	public static void main(String []args) {
		
		ImageCapturer imageCapturer = new ConsoleImageCapturer();
		AlarmChannel alarmChannel = new ConsoleAlarmChannel();
		
		MotionDetector motionDetector = new MotionDetector(imageCapturer);
		motionDetector.registerAlarmChannel(alarmChannel);
		
		motionDetector.runMotionDetector();
	}
}
