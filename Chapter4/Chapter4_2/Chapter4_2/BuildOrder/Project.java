package Chapter4_2.BuildOrder;

import java.util.ArrayList;
import java.util.HashMap;

public class Project {
    public enum State {COMPLETE, PARTIAL, BLANK}

    private HashMap<String, Project> map = new HashMap<>();
    private ArrayList<Project> childern = new ArrayList<>();
    private String name;
    private State state = State.BLANK;

    public void addNeighbour(Project node) {
        if (!map.containsKey(node.getName())) {
            childern.add(node);
            map.put(node.getName(), node);
        }
    }

    public Project(String name) {
        this.name = name;
    }

    public ArrayList<Project> getChildern() {
        return childern;
    }

    public State getState() {
        return state;
    }

    public String getName() {
        return name;
    }

    public void setState(State state) {
        this.state = state;
    }
}
