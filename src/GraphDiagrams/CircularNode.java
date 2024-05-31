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
	
	@Override
	public double getArea() {
		return this.radius * this.radius * (314.0 /100.0);
	}
	
	@Override
	public boolean isIsomorphicWith(Node other) {
		return other instanceof CircularNode cn && cn.radius == this.radius;
	}
}
