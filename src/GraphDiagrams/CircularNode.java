package GraphDiagrams;

public class CircularNode extends Node{
	
	/**
	 * @invar | radius > 0
	 */
	private int radius; 
	/**
	 * @throws IllegalArgumentException 
	 * | radius < 0
	 * @post | getRadius() == radius
	 */
	public CircularNode(int radius) {
		this.radius = radius;
	}
	
	/**
	 * @post | result > 0
	 */
	public int getRadius() {
		return radius;
	}
}
