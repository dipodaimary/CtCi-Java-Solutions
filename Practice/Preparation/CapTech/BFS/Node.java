package Preparation.CapTech.BFS;

import java.util.ArrayList;

public class Node {
    public int data;
    State state;
    ArrayList<Node> adjacencyList;

    public Node(int d) {
        this.data = d;
        adjacencyList = new ArrayList<>();
    }

    public void addNeighbour(Node n) {
        this.adjacencyList.add(n);
    }

    public ArrayList<Node> getAdjacencyList() {
        return this.adjacencyList;
    }

    public void setState(State s) {
        this.state = s;
    }
}
