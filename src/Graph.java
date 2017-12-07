import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by simen on 28.11.2017.
 */
public class Graph {
    private int N, K;
    private Node[] nodes;
    ArrayList<Node> toBeSorted = new ArrayList<>();

    public void newGraph(BufferedReader bufferedReader) throws IOException{
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node(i);
        }
        K = Integer.parseInt(stringTokenizer.nextToken());
        for (int i = 0; i < K; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(stringTokenizer.nextToken());
            int to = Integer.parseInt(stringTokenizer.nextToken());
            Edge e = new Edge(nodes[to],nodes[from].getFirstEdge());
            nodes[from].setFirstEdge(e);
        }
    }

    public void initPrev(Node startNode){
        for (int i = N-1; i >0; --i) {
            nodes[i].setData(new Previous());
        }
        startNode.setData(new Previous());
        ((Previous) startNode.getData()).setDistance(0);
        ((Previous) startNode.getData()).setPreviousNode(startNode);
    }

    public void bfs(Node startNode){
        initPrev(startNode);
        ArrayList<Node> queue = new ArrayList<>();
        queue.add(startNode);
        while(queue.size()!=0){
            Node nextNode = queue.get(0);
            toBeSorted.add(nextNode);
            queue.remove(0);
            for(Edge edge = nextNode.getFirstEdge(); edge!=null; edge=edge.getNextEdge()) {
                Previous previous = (Previous)edge.getToNode().getData();
                if(previous.getDistance()==previous.getINF()){
                    previous.setDistance(((Previous)nextNode.getData()).getDistance()+1);
                    previous.setPreviousNode(nextNode);
                    queue.add(edge.getToNode());
                }
            }
        }
    }

    public static void getNodeInfo(int nodenr, int prevnr, Node node,Formatter formatter){
        System.out.printf("%6d %6d %6d",nodenr, prevnr,((Previous)node.getData()).getDistance());

    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        Formatter formatter = new Formatter();
        try {
            FileReader fileReader = new FileReader("L7g3.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            graph.newGraph(bufferedReader);
            graph.initPrev(graph.getNodes()[0]);
            graph.bfs(graph.getNodes()[0]);
            Collections.sort(graph.toBeSorted);
            int i = 0;
            for (Node node :graph.toBeSorted) {
                getNodeInfo(node.getNr(), ((Previous)node.getData()).getPreviousNode().getNr(), node, formatter);
                System.out.println();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public int getK() {
        return K;
    }

    public int getN() {
        return N;
    }

    public Node[] getNodes() {
        return nodes;
    }
}
