package Chapter4;

import java.util.LinkedList;

public class RouteBetweenNodes {
    public static void main(String[] args) {
        Graph g = createNewGraph();
        Node[] n = g.getVertices();
        System.out.println(search(g, n[3], n[5]));
    }

    public static Graph createNewGraph() {
        Graph g = new Graph();
        Node[] temp = new Node[6];

        temp[0] = new Node("a", 3);
        temp[1] = new Node("b", 0);
        temp[2] = new Node("c", 0);
        temp[3] = new Node("d", 1);
        temp[4] = new Node("e", 1);
        temp[5] = new Node("f", 0);

        temp[0].addAdjacent(temp[1]);
        temp[0].addAdjacent(temp[2]);
        temp[0].addAdjacent(temp[3]);
        temp[3].addAdjacent(temp[4]);
        temp[4].addAdjacent(temp[5]);
        for (int i = 0; i < 6; i++) {
            g.addNode(temp[i]);
        }
        return g;
    }

    public static boolean search(Graph g, Node start, Node end) {
        if (start == end) {
            return true;
        }
        LinkedList<Node> q = new LinkedList<>();
        for (Node u : g.getVertices()) {
            u.setState(State.Unvisited);
        }
        start.setState(State.Unvisited);
        q.addLast(start);
        Node u;
        while (!q.isEmpty()) {
            u = q.removeFirst();
            for (Node v : u.getAdjacencyList()) {
                if (v.getState() == State.Unvisited) {
                    if (v == end) {
                        return true;
                    } else {
                        v.setState(State.Visiting);
                        q.add(v);
                    }
                }
            }
            u.setState(State.Visited);
        }
        return false;
    }
}

enum State {
    Unvisited, Visited, Visiting;
}

class Node {
    private String vertex;
    private Node[] adjacencyList;
    private int adjacentCount;
    private State state;

    public Node(String v, int adjacentLength) {
        this.vertex = v;
        adjacencyList = new Node[adjacentLength];
        this.adjacentCount = 0;
    }

    public void addAdjacent(Node x) {
        if (this.adjacentCount < adjacencyList.length) {
            this.adjacencyList[adjacentCount] = x;
            adjacentCount++;
        } else {
            System.out.println("No more adjacency Can be added");
        }
    }

    public String getVertex() {
        return vertex;
    }

    public Node[] getAdjacencyList() {
        return adjacencyList;
    }

    public int getAdjacentCount() {
        return adjacentCount;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
}

class Graph {
    private Node[] vertices;
    private int count;
    public static int MAX_VERTICES = 6;

    public Graph() {
        vertices = new Node[MAX_VERTICES];
        count = 0;
    }

    public void addNode(Node x) {
        if (count < vertices.length) {
            vertices[count] = x;
            count++;
        } else {
            System.out.println("Graph Full");
        }
    }

    public Node[] getVertices() {
        return vertices;
    }
}