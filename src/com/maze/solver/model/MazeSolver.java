package com.maze.solver.model;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public class MazeSolver {

    private final int[][] MOVEMENTS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    // apply BFS
    public boolean solve(Maze maze) {
        Set<Location> visited = new LinkedHashSet<>();
        LinkedList<Location> queue = new LinkedList<>();
        queue.add(maze.getStart());

        while (!queue.isEmpty()) {
            Location current = queue.remove();

            if (!visited.contains(current)) {
                visited.add(current);

                if (current.equals(maze.getEnd())) {
                    while ((current = current.getPrevious()) != null && !current.equals(maze.getStart())) {
                        current.setDescription(Location.Description.PATH);
                    }
                    return true;
                }

                for (int[] movement : MOVEMENTS) {
                    Location next = maze.getLocation(current.getY() + movement[1], current.getX() + movement[0]);
                    if (next != null && next.getDescription() != Location.Description.WALL) {
                        next.setPrevious(current);
                        queue.add(next);
                    }
                }
            }
        }
        return false;
    }
}
