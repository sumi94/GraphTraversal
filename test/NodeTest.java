import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NodeTest {

    List adjacentNodes = new ArrayList();
    Node a = new Node("a",false, new ArrayList<Node>());
    Node b = new Node("b",false, new ArrayList<Node>());
    Node c = new Node("c",false, new ArrayList<Node>());
    Node d = new Node("d",false, new ArrayList<Node>());
    Node e = new Node("e",false, new ArrayList<Node>());
    Node f = new Node("f",false, new ArrayList<Node>());
    Node g = new Node("g",false, new ArrayList<Node>());
    Node h = new Node("h",false, new ArrayList<Node>());

    @Before
    public void setUp() throws Exception {
        h.connectTo(b);
        b.connectTo(a);
        b.connectTo(c);
        a.connectTo(f);
        c.connectTo(d);
        c.connectTo(e);
        d.connectTo(e);
        e.connectTo(b);
    }

    @Test
    public void shouldMarkVistitedTrueWhenIInvokeTheMethod() {
        boolean visited = false;
        Node node = new Node("a",visited, null);
        node.visit();
        assertEquals(true,node.getVisited());
    }

    @Test
    public void shouldFindIfTheNodeIsAdjacent() {
        List<Node> adjacentNodes = new ArrayList<>();
        Node b = new Node("b",false, null);
        Node c = new Node("c",false, null);
        Node a = new Node("a",false,adjacentNodes);
        adjacentNodes.add(b);
        adjacentNodes.add(c);
        assertTrue(a.canReach(b));
    }

    @Test
    public void shouldFindDFromA() {
        List<Node> adjacentNodes = new ArrayList<>();
        Node a = new Node("a",false,adjacentNodes);
        Node c = new Node("c",false, null);
        Node d = new Node("d",false, null);
        Node b = new Node("b",false, new ArrayList<Node>(Arrays.asList(d)));
        adjacentNodes.add(b);
        adjacentNodes.add(c);
        assertTrue(a.canReach(d));
    }

    @Test
    public void shouldFindDFromH() {
        Node d = new Node("d",false, new ArrayList<Node>());
        Node c = new Node("c",false, new ArrayList<Node>(Arrays.asList(d)));
        Node a = new Node("a",false, new ArrayList<Node>());
        Node b = new Node("b",false, new ArrayList<Node>(Arrays.asList(a, c)));
        Node h = new Node("h",false,new ArrayList<Node>(Arrays.asList(b)));
        assertTrue(h.canReach(d));
    }

    @Test
    public void shouldAddDAsAdjacentToC() {
        Node d = new Node("d",false, new ArrayList<Node>());
        Node c = new Node("c",false, new ArrayList<Node>());
        c.connectTo(d);
        assertEquals(1, c.noOfAdjacents());
    }


    @Test
    public void shouldFindEFromH() {
        Node e = new Node("e",false, new ArrayList<Node>());
        Node d = new Node("d",false, new ArrayList<Node>());
        Node c = new Node("c",false, new ArrayList<Node>(Arrays.asList(d)));
        Node a = new Node("a",false, new ArrayList<Node>());

        Node b = new Node("b",false, new ArrayList<Node>(Arrays.asList(a, c)));
        Node h = new Node("h",false,new ArrayList<Node>(Arrays.asList(b)));
        assertFalse(h.canReach(e));
    }


    @Test
    public void shouldFindDFromE() {
        e.connectTo(b);
        b.connectTo(c);
        c.connectTo(e);
        c.connectTo(d);
        d.connectTo(h);
        assertTrue(e.canReach(h));
    }

    @Test
    public void shoudFindFFromC() {
        assertTrue(c.canReach(f));
    }

    @Test
    public void shoudNotFindFFromC() {
        assertFalse(e.canReach(g));
    }

    @Test
    public void shoudFindEFromE() {
        assertTrue(e.canReach(e));
    }

    @Test
    public void shouldFindHFromH() {
        assertTrue(h.canReach(h));
    }
}
