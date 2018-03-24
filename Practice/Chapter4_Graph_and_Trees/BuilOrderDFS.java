package Trees_and_Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class BuilOrderDFS {
    public Stack<Project> findBuildOrder(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }

    private Stack<Project> orderProjects(ArrayList<Project> projects) {
        Stack<Project> stack = new Stack<>();
        for (Project project : projects) {
            if (project.getState() == Project.State.BLANK) {
                if (!doDFS(project, stack)) {
                    return null;
                }
            }
        }
        return stack;
    }

    private boolean doDFS(Project project, Stack<Project> stack) {
        if (project.getState() == Project.State.PARTIAL) {
            return false;//cycle
        }
        if (project.getState() == Project.State.BLANK) {
            project.setState(Project.State.PARTIAL);
            ArrayList<Project> childern = project.getChildern();
            for (Project child : childern) {
                if (!doDFS(child, stack)) {
                    return false;
                }
            }
            project.setState(Project.State.COMPLETE);
            stack.push(project);
        }
        return true;
    }

    private Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();
        for (String project : projects) {
            graph.getOrCreateNode(project);
        }
        for (String[] dependency : dependencies) {
            String first = dependency[0];
            String second = dependency[1];
            graph.addEdge(first, second);
        }
        return graph;
    }
}

class Graph {
    private ArrayList<Project> nodes;
    private HashMap<String, Project> map = new HashMap<>();

    public Project getOrCreateNode(String name) {
        if (!map.containsKey(name)) {
            Project node = new Project(name);
            nodes.add(node);
            map.put(name, node);
        }
        return map.get(name);
    }

    public void addEdge(String startName, String endName) {
        Project start = getOrCreateNode(startName);
        Project end = getOrCreateNode(endName);
        start.addNeighbour(end);
    }

    public ArrayList<Project> getNodes() {
        return nodes;
    }
}

class Project {
    public enum State {COMPLETE, PARTIAL, BLANK}

    private State state = State.BLANK;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    private ArrayList<Project> childern;
    HashMap<String, Project> map;
    private String name;
    private int dependencies = 0;

    public Project(String n) {
        name = n;
    }

    public void addNeighbour(Project node) {
        if (!map.containsKey(node.getName())) {
            childern.add(node);
            map.put(node.getName(), node);
            node.incrementDependencies();
        }
    }

    public String getName() {
        return name;
    }

    public void incrementDependencies() {
        this.dependencies++;
    }

    public void decrementDependencies() {
        this.dependencies--;
    }

    public int getNumberDependencies() {
        return dependencies;
    }

    public ArrayList<Project> getChildern() {
        return childern;
    }
}