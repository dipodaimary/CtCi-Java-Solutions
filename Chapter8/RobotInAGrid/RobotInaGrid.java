package Chapter8.RobotInAGrid;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class RobotInaGrid {
    public static void main(String[] args) {
        int size = 20;
        boolean[][] maze = new boolean[20][20];
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 20; j++) {
                maze[i][j] = r.nextBoolean();
            }
        }

        ArrayList<Point> path = getPath(maze);
        if (path != null) {
            System.out.println(path.toString());
        } else {
            System.out.println("No path found.");
        }
    }


    public static ArrayList<Point> getPath(boolean[][] maze) {
        if (maze == null || maze.length == 0) {
            return null;
        }
        ArrayList<Point> path = new ArrayList<>();
        HashSet<Point> failedPoints = new HashSet<>();
        if (getPath(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
            return path;
        }
        return null;
    }

    private static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints) {
        //if out of bounds or not availbe return
        if (col < 0 || row < 0 || !maze[row][col]) {
            return false;
        }
        Point p = new Point(row, col);
        if (failedPoints.contains(p)) {
            return false;
        }
        boolean isAtOrigin = (row == 0) && (col == 0);
        if (isAtOrigin || getPath(maze, row, col - 1, path, failedPoints) || getPath(maze, row - 1, col, path, failedPoints)) {
            path.add(p);
            return true;
        }
        failedPoints.add(p);
        return false;
    }
}