package box_volume;

public class BoxVolumeApplication {

	public static void main(String []args) {
		
		Box box1 = new Box(1, 2, 2);
		Box box2 = new Box(1, 2, 2);
		
		if(box1.getVolume() > box2.getVolume()) {
			
			System.out.println("box1 has a larger volume.");
			
			System.out.println(box1);
			
			return;
		}
		
		if(box1.getVolume() < box2.getVolume()) {
			
			System.out.println("box2 has a larger volume.");
			
			System.out.println(box2);
			
			return;
		}
		
		System.out.println("box1 and box2 have equal volumes.");
		
		System.out.println(box1);
	}
}
