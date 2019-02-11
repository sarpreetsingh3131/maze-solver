package com.maze.solver.model;

public class Maze {

    private int width;
    private int height;
    private Location start;
    private Location end;
    private Location matrix[][];

    public Maze(int width, int height, Location start, Location end, Location[][] matrix) {
        this.width = width;
        this.height = height;
        this.start = start;
        this.end = end;
        this.matrix = matrix;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Location getStart() {
        return start;
    }

    public Location getEnd() {
        return end;
    }

    public Location getLocation(int row, int col) {
        if (row < 0) { // for vertical wrapping
            return matrix[height - 1][col];
        }
        if (col < 0) { // for horizontal wrapping
            return matrix[row][width - 1];
        }
        if (row < height && col < width) {
            return matrix[row][col];
        }
        return null;
    }
}
