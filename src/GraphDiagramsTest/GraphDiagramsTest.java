package GraphDiagramsTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import GraphDiagrams.Arc;
import GraphDiagrams.CircularNode;
import GraphDiagrams.Node;
import GraphDiagrams.RectangularNode;

class GraphDiagramsTest {

	@Test
	void test() {
		Node node = new Node();
		assertTrue(node.getIncomingArcs().isEmpty());
		assertTrue(node.getOutgoingArcs().isEmpty());
		
		Arc arc = new Arc(45);
		assertEquals(arc.getAngle(), 45);
		assertNull(arc.getSource());
		assertNull(arc.getTarget());
		
		RectangularNode rectangle = new RectangularNode(10, 5);
		assertEquals(rectangle.getHeight(), 5);
		assertEquals(rectangle.getWidth(), 10);
		assertEquals(rectangle.getArea(), 50);
		assertTrue(rectangle.isIsomorphicWith(new RectangularNode(10, 5)));
		
		CircularNode circle = new CircularNode(2);
		assertEquals(circle.getRadius(), 2);
		assertEquals(circle.getArea(), 12.56);
		assertTrue(circle.isIsomorphicWith(new CircularNode(2)));
		
		// adding 
		arc.setSource(node);
		assertEquals(arc.getSource(), node);
		assertTrue(node.getOutgoingArcs().contains(arc));
		
		arc.setTarget(node);
		assertEquals(arc.getTarget(), node);
		assertTrue(node.getIncomingArcs().contains(arc));
		
		// removing
		arc.unlinkSourceNode(node);
		assertNull(arc.getSource());
		assertTrue(!node.getOutgoingArcs().contains(arc));
		
		arc.unlinkTargetNode(node);
		assertNull(arc.getTarget());
		assertTrue(!node.getIncomingArcs().contains(arc));
	}

}
