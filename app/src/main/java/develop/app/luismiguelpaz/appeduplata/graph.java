package develop.app.luismiguelpaz.appeduplata;

import java.util.ArrayList;
import java.util.HashMap;

public class graph {

    private HashMap<node, ArrayList<node>> adjList;

    private HashMap<Integer, node> nodes;

    public graph(int n, HashMap<Integer, node> nodes) {
        this.nodes = nodes;
        adjList = new HashMap<node, ArrayList<node>>();

        for (int i = 1; i <= n; i++) {
            adjList.put(nodes.get(i), new ArrayList<node>());
        }

    }

    public void addEdge(int u, int v) {
        node nodeP = nodes.get(u);
        node nodeS = nodes.get(v);
        adjList.get(nodeP).add(nodeS);

    }

    public HashMap<node, ArrayList<node>> getAdjList() {
        return adjList;
    }

    public void setAdjList(HashMap<node, ArrayList<node>> adjList) {
        this.adjList = adjList;
    }

    public HashMap<Integer, node> getNodes() {
        return nodes;
    }

    public void setNodes(HashMap<Integer, node> nodes) {
        this.nodes = nodes;
    }
}
