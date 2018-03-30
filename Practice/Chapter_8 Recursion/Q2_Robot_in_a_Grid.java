package Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Q2_Robot_in_a_Grid {
    public static void main(String[] args) {
        int size = 5;
        Random r = new Random();
        boolean[][] maze = new boolean[size][size];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                maze[i][j] = r.nextBoolean();
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }

        ArrayList<Point> path = getPathOptimized(maze);
        if (path != null) {
            System.out.println(path.toString());
        } else {
            System.out.println("No path found.");
        }
    }


    public static ArrayList<Point> getPath(boolean[][] maze) {
        if (maze == null || maze.length == 0) return null;
        ArrayList<Point> path = new ArrayList<>();
        if (getPath(maze, maze.length - 1, maze[0].length - 1, path)) {
            return path;
        }
        return null;
    }

    private static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path) {
        //out of bounds or not available
        if (col < 0 || row < 0 || !maze[row][col]) {
            return false;
        }
        boolean isAtOrigin = (row == 0) && (col == 0);
        /*
        If there is a path from start to here then add my location
         */
        if (isAtOrigin || getPath(maze, row - 1, col, path) || getPath(maze, row, col - 1, path)) {
            Point p = new Point(row, col);
            path.add(p);
            return true;
        }
        return false;
    }

    public static ArrayList<Point> getPathOptimized(boolean[][] maze) {
        if (maze == null || maze.length == 0) {
            return null;
        }
        ArrayList<Point> path = new ArrayList<>();
        HashSet<Point> failedPoints = new HashSet<>();
        if (getPathOptimized(maze, maze.length - 1, maze.length - 1, path, failedPoints)) {
            return path;
        }
        return null;
    }

    private static boolean getPathOptimized(boolean[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints) {
        //If out bounds or unreachable
        if (row < 0 || col < 0 || !maze[row][col]) {
            return false;
        }
        Point p = new Point(row, col);
        // Check if already in f
        if (failedPoints.contains(p)) {
            return false;
        }
        boolean isAtOrigin = (row == 0) && (col == 0);
        /*
        If there is a path from start to my location then add p
         */
        if (isAtOrigin || getPathOptimized(maze, row - 1, col, path, failedPoints) || getPathOptimized(maze, row, col - 1, path, failedPoints)) {
            path.add(p);
            return true;
        }
        failedPoints.add(p); //cache result
        return false;
    }
}

class Point {
    int row;
    int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return "(" + row + ", " + col + ")";
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if ((o instanceof Point) && (((Point) o).row == this.row) && ((((Point) o).col == this.row))) {
            return true;
        } else {
            return false;
        }
    }
}