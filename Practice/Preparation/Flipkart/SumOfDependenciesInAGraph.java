package Preparation.Flipkart;

import java.util.ArrayList;

public class SumOfDependenciesInAGraph {
    public static void main(String[] args) {
        Node[] nodes = new Node[4];
        for (int i = 0; i < 4; i++) {
            nodes[i] = new Node(i);
        }
        nodes[0].addEdge(nodes[3]);
        nodes[0].addEdge(nodes[2]);
        nodes[1].addEdge(nodes[3]);
        nodes[2].addEdge(nodes[3]);

        System.out.println(sumDependencies(nodes));
    }

    public static int sumDependencies(Node[] nodes) {
        int sum = 0;
        for (Node node : nodes) {
            sum += node.adj.size();
        }
        return sum;
    }
}

class Node {
    public int data;
    public ArrayList<Node> adj;

    Node(int d) {
        this.data = d;
        adj = new ArrayList<>();
    }

    public void addEdge(Node n) {
        this.adj.add(n);
    }
}