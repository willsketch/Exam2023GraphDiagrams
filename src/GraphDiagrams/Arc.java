package GraphDiagrams;
import logicalcollections.LogicalSet;

/**
 * @invar | getSource() == null || getSource().getOutgoingArcs().contains(this)
 * @invar | getTarget() == null || getTarget().getIncomingArcs().contains(this)
 */
public class Arc { 
	
	/**
	 * @invar | angle > 0 && angle < 359
	 */
	private int angle; 
	
	/**
	 * @invar | target == null || target.getIncomingArcs().contains(this)
	 */
	private Node target;
	
	/**
	 * @invar | source == null || source.getOutgoingArcs().contains(this)
	 */
	private Node source;
	
	/**
	 * @throws IllegalArgumentException
	 * |	angle < 0 || angle > 359
	 * @post | getAngle() == angle
	 * @post | getTarget() == null
	 * @post | getSource() == null
	 */
	public Arc(int angle) {
		if (angle < 0 || angle > 359) {
			throw new IllegalArgumentException();
		}
		this.angle = angle;
		this.target = null;
		this.source = null;
	}
	
	/**
	 * @post | result > 0 && result < 359 
	 */
	public int getAngle() {
		return this.angle;
	}
	
	public Node getTarget() {
		return this.target;
	}
	
	public Node getSource() {
		return this.source;
	}
	
	/**
	 * @pre | node != null
	 * @pre | getSource() == null
	 * @mutates_properties| getSource(), node.getOutgoingArcs()
	 * @post | getSource().equals(node)
	 * @post | node.getOutgoingArcs().equals(LogicalSet.plus(old(node.getOutgoingArcs()), this))
	 */
	public void setSource(Node node) {
		this.source = node;
		node.outgoingArcs.add(this);
	}
	
	/**
	 * @pre | node != null
	 * @pre | getTarget() == null
	 * @mutates_properties| getTarget(), node.getIncomingArcs()
	 * @post | getTarget().equals(node)
	 * @post | node.getIncomingArcs().equals(LogicalSet.plus(old(node.getIncomingArcs()), this))
	 */
	public void setTarget(Node node) {
		this.target = node;
		node.incomingArcs.add(this);
	}
	
	/**
	 * @pre | node != null
	 * @mutates_properties| getTarget(), node.getIncomingArcs()
	 * @post | getTarget() == null
	 * @post | node.getIncomingArcs().equals(LogicalSet.minus(old(node.getIncomingArcs()), this))
	 */
	public void unlinkTargetNode(Node node) {
		this.target = null;
		node.incomingArcs.remove(this);
	}
	
	/**
	 * @pre | node != null
	 * @mutates_properties| getSource(), node.getOutgoingArcs()
	 * @post | getSource() == null
	 * @post | node.getOutgoingArcs().equals(LogicalSet.minus(old(node.getOutgoingArcs()), this))
	 */
	public void unlinkSourceNode(Node node) {
		this.source = null;
		node.outgoingArcs.remove(this);
	}
}
