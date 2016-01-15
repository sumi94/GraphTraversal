import java.util.ArrayList;
import java.util.List;

public class Node {

    private final String name;
    private boolean visited;
    private List<Node> adjacentNodes;

    public Node(String name, List<Node> adjacentNodes) {
        this.name = name;
        this.adjacentNodes = adjacentNodes;
    }

    public boolean isPathAvailable(Node nodeToFind) {
        List<Node> visitedNodes = new ArrayList<>();
        return canReach(nodeToFind, visitedNodes);
    }

    private boolean canReach(Node nodeToFind, List<Node> visitedNodes) {
        visitedNodes.add(this);
        if( this.equals(nodeToFind)) {
            return true;
        }
        for(Node node : adjacentNodes){
            if(!visitedNodes.contains(node) && node.canReach(nodeToFind,visitedNodes)){
                return true;
            }
        }
        return false;
    }

    public void connectTo(Node node) {
        adjacentNodes.add(node);
    }

    public int noOfAdjacents() {
        return adjacentNodes.size();
    }

}
