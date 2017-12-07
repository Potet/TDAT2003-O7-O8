import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class TopoSort {
    int N,K;
    Node[] nodes;


    public static void main(String[] args) {
        TopoSort t = new TopoSort();
        t.printTopoSort("L7g2");
    }

    public void printTopoSort(String filename) {
        makeGraphFromFile(filename);
        Node n = topoSort();
        Topo_lst t = (Topo_lst) n.getData();
        while (n != null) {
            System.out.println(getNr(n));
            if(t.nextNode != null) {
                n = t.nextNode;
                t = (Topo_lst) n.getData();
            } else {
                return;
            }
        }
    }
    public String getNr(Node noden) {
        String nr = "";
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == noden) {
                return nr + i;
            }
        }
        return nr + " ";
    }

    Node df_topo(Node n, Node l){
        Topo_lst nd = (Topo_lst)n.getData();
        if(nd.found)return l;
        nd.found = true;
        for(Edge e = n.getFirstEdge(); e!=null; e = e.getNextEdge()){
            l = df_topo(e.getToNode(),l);
        }
        return l;
    }
    Node topoSort(){
        Node l = null;
        for (int i = N; --i>0;) {
            nodes[i].setData(new Topo_lst());
        }
        for (int i = N; --i>0;) {
            l = df_topo(nodes[i], l);
        }
        return l;
    }
    public void makeGraphFromFile(String filename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            nodes = new Node[N];

            for (int i = 0; i < N; i++) {
                nodes[i] = new Node(i+1);
            }

            K = Integer.parseInt(st.nextToken());

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                Edge e = new Edge(nodes[to], nodes[from].getFirstEdge());
                nodes[from].setFirstEdge(e);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
