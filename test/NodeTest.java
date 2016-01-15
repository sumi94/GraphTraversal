import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NodeTest {

    Node a = new Node("a", new ArrayList<Node>());
    Node b = new Node("b", new ArrayList<Node>());
    Node c = new Node("c", new ArrayList<Node>());
    Node d = new Node("d", new ArrayList<Node>());
    Node e = new Node("e", new ArrayList<Node>());
    Node f = new Node("f", new ArrayList<Node>());
    Node g = new Node("g", new ArrayList<Node>());
    Node h = new Node("h", new ArrayList<Node>());
    Node k = new Node("h", new ArrayList<Node>());

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
    public void shouldFindIfTheNodeIsAdjacent() {
        List<Node> adjacentNodes = new ArrayList<>();
        Node b = new Node("b", null);
        Node c = new Node("c", null);
        Node a = new Node("a", adjacentNodes);
        adjacentNodes.add(b);
        adjacentNodes.add(c);
        assertTrue(a.isPathAvailable(b));
    }

    @Test
    public void shouldFindDFromA() {
        List<Node> adjacentNodes = new ArrayList<>();
        Node a = new Node("a", adjacentNodes);
        Node c = new Node("c", null);
        Node d = new Node("d", null);
        Node b = new Node("b", new ArrayList<Node>(Arrays.asList(d)));
        adjacentNodes.add(b);
        adjacentNodes.add(c);
        assertTrue(a.isPathAvailable(d));
    }

    @Test
    public void shouldFindDFromH() {
        Node d = new Node("d", new ArrayList<Node>());
        Node c = new Node("c", new ArrayList<Node>(Arrays.asList(d)));
        Node a = new Node("a", new ArrayList<Node>());
        Node b = new Node("b", new ArrayList<Node>(Arrays.asList(a, c)));
        Node h = new Node("h", new ArrayList<Node>(Arrays.asList(b)));
        assertTrue(h.isPathAvailable(d));
    }

    @Test
    public void shouldAddDAsAdjacentToC() {
        Node d = new Node("d", new ArrayList<Node>());
        Node c = new Node("c", new ArrayList<Node>());
        c.connectTo(d);
        assertEquals(1, c.noOfAdjacents());
    }


    @Test
    public void shouldFindEFromH() {
        Node e = new Node("e", new ArrayList<Node>());
        Node d = new Node("d", new ArrayList<Node>());
        Node c = new Node("c", new ArrayList<Node>(Arrays.asList(d)));
        Node a = new Node("a", new ArrayList<Node>());

        Node b = new Node("b", new ArrayList<Node>(Arrays.asList(a, c)));
        Node h = new Node("h", new ArrayList<Node>(Arrays.asList(b)));
        assertFalse(h.isPathAvailable(e));
    }


    @Test
    public void shouldFindDFromE() {
        e.connectTo(b);
        b.connectTo(c);
        c.connectTo(e);
        c.connectTo(d);
        d.connectTo(h);
        assertTrue(e.isPathAvailable(h));
    }

    @Test
    public void HIsEqualToH() {
        assertEquals(h, h);
    }

    @Test
    public void shoudFindFFromC() {
        assertTrue(c.isPathAvailable(f));
    }

    @Test
    public void shoudNotFindGFromE() {
        assertFalse(e.isPathAvailable(g));
    }

    @Test
    public void shoudFindEFromE() {
        assertTrue(e.isPathAvailable(e));
    }

}
