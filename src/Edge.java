/**
 * Created by simen on 28.11.2017.
 */
public class Edge {
    private Edge nextEdge;
    private Node toNode;

    public Edge(Node toNode, Edge nextEdge){
        this.toNode = toNode;
        this.nextEdge = nextEdge;
    }
    public Edge(){}

    public Edge getNextEdge() {
        return nextEdge;
    }

    public Node getToNode() {
        return toNode;
    }

    public void setNextEdge(Edge nextEdge) {
        this.nextEdge = nextEdge;
    }

    public void setToNode(Node toNode) {
        this.toNode = toNode;
    }
}
