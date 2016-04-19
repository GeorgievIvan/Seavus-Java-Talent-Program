package motion_detector;

import java.util.ArrayList;

public class MotionDetector {

	private final ImageCapturer imageCapturer;
	private final ArrayList<AlarmChannel> alarmChannels;
	
	public MotionDetector(final ImageCapturer imageCapturer) {
		
		this.imageCapturer = imageCapturer;
		
		alarmChannels = new ArrayList<AlarmChannel>();
	}
	
	public void registerAlarmChannel(final AlarmChannel alarmChannel) {
		
		alarmChannels.add(alarmChannel);
	}
	
	public void runMotionDetector() {
		
		String previousImage = requestImage();
		
		while(!previousImage.equals("")) {
			
			String newImage = requestImage();
			
			if(newImage.equals("")) {
				
				return;
			}
			
			if(!compareImages(previousImage, newImage)) {
				
				informAlarmChannels();
			}
			
			previousImage = newImage;
		}
	}
	
	private void informAlarmChannels() {
		
		for(AlarmChannel alarmChannel : alarmChannels) {
			
			alarmChannel.alarm();
		}
	}
	
	private boolean compareImages(final String image1, final String image2) {
		
		return image1.equals(image2);
	}
	
	private String requestImage() {
		
		String image = imageCapturer.captureImage();

		return image;
	}
}
