package Trees_and_Graphs;

import java.util.LinkedList;

public class RouteBetweenTwoNodes {
    public boolean serach(Graph g, Node start, Node end) {
        if (start == end) {
            return true;
        }
        LinkedList<Node> q = new LinkedList<>();
        for (Node u : g.getVertices()) {
            u.setState(State.unvisited);
        }
        start.setState(State.unvisited);
        q.addLast(start);
        Node u;
        while (!q.isEmpty()) {
            u = q.removeFirst();
            for (Node v : u.getAdjacencyList()) {
                if (v.getState() == State.unvisited) {
                    if (v == end) {
                        return true;
                    } else {
                        v.setState(State.visiting);
                        q.add(v);
                    }
                }
            }
            u.setState(State.visited);
        }
        return false;
    }
}

enum State {
    visited, unvisited, visiting;
}

class Node {
    private String vertex;
    private int adjacenciesCount;
    private Node[] adjacencyList;
    private State state;

    public Node(String v, int adjacentLength) {
        this.vertex = v;
        adjacencyList = new Node[adjacentLength];
        adjacenciesCount = 0;
        state = State.unvisited;
    }

    public void addAdjacent(Node n) {
        if (adjacenciesCount >= adjacencyList.length) {
            System.out.println("No more adjacencies can be added");
        } else {
            adjacencyList[adjacenciesCount] = n;
            adjacenciesCount++;
        }
    }

    public String getVertex() {
        return this.vertex;
    }

    public Node[] getAdjacencyList() {
        return this.adjacencyList;
    }

    public int getAdjacenciesCount() {
        return adjacenciesCount;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return this.state;
    }
}

class Graph {
    Node[] vertices;
    int count;
    static int MAX_VERTICES = 6;

    public Graph() {
        vertices = new Node[MAX_VERTICES];
        count = 0;
    }

    public void addNode(Node n) {
        if (count < MAX_VERTICES) {
            vertices[count] = n;
            count++;
        } else {
            System.out.println("Graph Full");
        }
    }

    public Node[] getVertices() {
        return vertices;
    }
}