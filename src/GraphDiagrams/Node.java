package GraphDiagrams;

import java.util.HashSet;
import java.util.Set;

import org.hamcrest.core.IsInstanceOf;

/**
 * @invar | getIncomingArcs().stream().allMatch(a -> a != null && a.getSource().equals(this))
 * @invar | getOutgoingArcs().stream().allMatch(a -> a != null && a.getTarget().equals(this))
 */
public abstract class Node {
	
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
	
	
	public abstract double getArea(); 
	
	public abstract boolean isIsomorphicWith(Node other);
}
