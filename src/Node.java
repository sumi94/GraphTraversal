import java.util.List;

public class Node {

    private final String name;
    private boolean visited;
    private List<Node> adjacentNodes;

    public Node(String name, boolean visited, List<Node> adjacentNodes) {
        this.name = name;
        this.visited = visited;
        this.adjacentNodes = adjacentNodes;
    }

    public void visit() {
         visited = true;
    }

    public boolean getVisited() {
        return visited;
    }

    public boolean canReach(Node nodeToFind) {
        this.visit();
        if(adjacentNodes.contains(nodeToFind)) {
            return true;
        }
        if(adjacentNodes.size()==0){
            return false;
        }
        for(Node node : adjacentNodes){
            if(!node.visited && node.canReach(nodeToFind)){
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
