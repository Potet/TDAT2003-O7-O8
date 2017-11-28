/**
 * Created by simen on 28.11.2017.
 */
public class Previous {
    private int distance;
    private Node previousNode;
    static final int INF = 1000000000;

    public Previous(){
        this.distance = INF;
    }
    public int compareTo(Previous previous){
        if(this.distance>previous.distance){
            return 1;
        }else if(this.distance==previous.distance){
            return 0;
        }
        return -1;
    }

    public int getDistance(){
        return distance;
    }

    public Node getPreviousNode() {
        return previousNode;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setPreviousNode(Node previousNode) {
        this.previousNode = previousNode;
    }

    public static int getINF() {
        return INF;
    }
}