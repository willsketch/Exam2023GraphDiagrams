package GraphDiagrams;

import java.util.HashSet;
import java.util.Set;

import org.hamcrest.core.IsInstanceOf;

/**
 * @invar | getIncomingArcs().stream().allMatch(a -> a != null && a.getSource().equals(this))
 * @invar | getOutgoingArcs().stream().allMatch(a -> a != null && a.getTarget().equals(this))
 */
public class Node {
	
	/**
	 * @representatiionObject
	 * @peerObjects
	 * @invar | incomingArcs != null
	 * @invar | incomingArcs.stream().allMatch(a -> a != null && a.getSource().equals(this))
	 */
	Set<Arc> incomingArcs;
	
	/**
	 * @representatiionObject
	 * @peerObjects
	 * @invar | outgoingArcs != null
	 * @invar | outgoingArcs.stream().allMatch(a -> a != null && a.getTarget().equals(this))
	 */
	Set<Arc> outgoingArcs;
	
	/**
	 * @post | getIncomingArcs().isEmpty()
	 * @post | getOutgoingArcs().isEmpty()
	 */
	public Node() {
		this.outgoingArcs = new HashSet<Arc>();
		this.incomingArcs = new HashSet<Arc>();
	}
	
	/**
	 * @creates | result
	 * @peerObjects
	 * @post | result != null
	 */
	public Set<Arc> getIncomingArcs(){
		return Set.copyOf(incomingArcs);
	}
	
	/**
	 * @creates | result
	 * @peerObjects
	 * @post | result != null
	 */
	public Set<Arc> getOutgoingArcs(){
		return Set.copyOf(outgoingArcs);
	}
	
	
	public double getArea() {
		if (this instanceof RectangularNode rn) {
			return rn.getHeight() * rn.getWidth();
		}
		else if (this instanceof  CircularNode cn) {
			return cn.getRadius() * cn.getRadius() * (314.0 / 100.0); 
		}
		else
			throw new RuntimeException();
	}
	
	public boolean isIsomorphicWith(Node other) {
		if (other instanceof RectangularNode rn1 && this instanceof RectangularNode rn2) {
			return rn1.getHeight() == rn2.getHeight() && rn1.getWidth() == rn2.getWidth();
		}
		else if (other instanceof CircularNode cn1 && this instanceof CircularNode cn2) {
			return cn1.getRadius() == cn2.getRadius();
		}
		else {
			return false;
		}
	}
}
