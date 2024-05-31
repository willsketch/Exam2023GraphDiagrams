package GraphDiagrams;

public class RectangularNode extends Node{
	
	/**
	 * @invar | height > 0
	 */
	private int height;
	
	/**
	 * @invar | width > 0
	 */
	private int width;
	/**
	 * @throws IllegalArgumentException 
	 * | width < 0 || height < 0
	 * @post | getHeight() == height
	 * @post | getWidth() == width 
	 */
	public RectangularNode(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	/**
	 * @post | result > 0
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * @post | result > 0
	 */
	public int getWidth() {
		return width;
	}
}
