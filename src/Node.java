/**
 * Created by simen on 28.11.2017.
 */
public class Node implements Comparable<Node>{
    private Edge firstEdge;
    private int nr;
    private Object data;

    public Node(Edge firstEdge){
        this.firstEdge = firstEdge;
        this.data = null;
    }
    public Node(int nr){
        this.nr = nr;
    }

    public int getNr() {
        return nr;
    }

    public Edge getFirstEdge() {
        return firstEdge;
    }
    public int compareTo(Node node){
        if(((Previous)this.data).getDistance()>((Previous)node.data).getDistance()){
            return 1;
        }else if(((Previous)this.data).getDistance()==((Previous)node.data).getDistance()){
            return 0;
        }
        return -1;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setFirstEdge(Edge firstEdge) {
        this.firstEdge = firstEdge;
    }
}
