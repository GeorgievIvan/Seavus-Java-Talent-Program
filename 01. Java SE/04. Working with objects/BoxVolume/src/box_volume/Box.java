package box_volume;

public class Box {
	
	private final int height;
	private final int width;
	private final int depth;
	
	public Box(final int height, final int width, final int depth) {
		
		this.height = height;
		
		this.width = width;
		
		this.depth = depth;
	}
	
	public int getHeight() {
		
		return height;
	}
	
	public int getWidth() {
		
		return width;
	}
	
	public int getDepth() {
		
		return depth;
	}
	
	public int getVolume() {
		
		int volume = height * width * depth;
		
		return volume;
	}
	
	public String toString() {
		
		return String.format("height: %d\nwidth: %d\ndepth: %d\nvolume: %d", height, width, depth, getVolume());
	}
}
