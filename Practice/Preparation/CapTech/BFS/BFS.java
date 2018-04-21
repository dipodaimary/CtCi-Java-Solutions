package Preparation.CapTech.BFS;

import java.util.LinkedList;

public class BFS {
    public static void main(String[] args) {
        Node[] nodes = new Node[7];
        for (int i = 0; i <= 6; i++) {
            nodes[i] = new Node(i);
        }
        nodes[0].addNeighbour(nodes[1]);
        nodes[1].addNeighbour(nodes[2]);
        nodes[2].addNeighbour(nodes[4]);
        nodes[4].addNeighbour(nodes[6]);
        nodes[4].addNeighbour(nodes[3]);
        nodes[6].addNeighbour(nodes[5]);
        System.out.println(isThereAPath(nodes, nodes[0], nodes[2]));
    }

    public static boolean isThereAPath(Node[] nodes, Node start, Node end) {
        if (nodes == null) {
            return false;
        }
        if (start == end) {
            return true;
        }
        LinkedList<Node> q = new LinkedList<>();
        for (Node u : start.getAdjacencyList()) {
            u.setState(State.Unvisited);
        }
        start.state = State.Visiting;

        q.add(start);
        Node u;
        while (!q.isEmpty()) {
            u = q.removeFirst(); //deque
            if (u != null) {
                for (Node v : u.getAdjacencyList()) {
                    if (v.state == State.Unvisited) {
                        if (v == end) {
                            return true;
                        } else {
                            v.state = State.Visiting;
                            q.add(v);
                        }
                    }
                }
            }
            u.state = State.Visited;
        }
        return false;
    }
}

enum State {Unvisited, Visiting, Visited;}