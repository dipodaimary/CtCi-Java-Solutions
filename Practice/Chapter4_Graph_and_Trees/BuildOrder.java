package Trees_and_Graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class BuildOrder {
    /*Find a correct build order
     */
    Project[] findBuildOrder(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }

    /*
    Build the graph, add the edge (a,b) if b is dependent on a. Assumes a pair is listed
    in "build order". The pair (a,b) in dependencies indicates that b depends on a and a
    must be built before b
     */
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

    /*
    Return a list of the projects a correct build order
     */
    private Project[] orderProjects(ArrayList<Project> projects) {
        Project[] order = new Project[projects.size()];
        //Add roots to the build order first
        int endOfList = addNonDependent(order, projects, 0);
        int toBeProcessed = 0;
        while (toBeProcessed < order.length) {
            Project current = order[toBeProcessed];
            /*
            We have a circular dependency since there are no remaining projects with
            zero dependencies
             */
            if (current == null) {
                return null;
            }
            //Remove myself as a dependency
            ArrayList<Project> childern = current.getChildern();
            for (Project child : childern) {
                child.decrementDependencies();
            }
            //Add childern that have no one depending on them
            endOfList = addNonDependent(order, childern, endOfList);
            toBeProcessed++;
        }
        return order;
    }

    /*
    A helper function to insert projects with zero dependencies into the order
    array, starting at index offset
     */
    private int addNonDependent(Project[] order, ArrayList<Project> projects, int offset) {
        for (Project project : projects) {
            if (project.getNumberDependencies() == 0) {
                order[offset] = project;
                offset++;
            }
        }
        return offset;
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