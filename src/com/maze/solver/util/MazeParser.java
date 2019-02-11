package com.maze.solver.util;

import com.maze.solver.model.Location;
import com.maze.solver.model.Maze;

import java.io.BufferedReader;

public class MazeParser {

    public Maze parse(BufferedReader bufferedReader) throws Exception {
        try {
            StringBuilder lines = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.append(line.trim() + "\n");
            }
            String[] data = lines.toString().split("[\r]?\n");

            // width, height of maze is at index 0, e.g., 4 4
            int width = parseInteger(data[0], 0);
            int height = parseInteger(data[0], 1);
            Location[][] matrix = new Location[height][width];

            // maze starts from index 3, add 3 to reach till max height
            for (int row = 3; row < height + 3; row++) {
                line = data[row].replaceAll(" ", "");
                for (int col = 0; col < width; col++) {
                    matrix[row - 3][col] = new Location(col, row - 3, parseDescription(line.charAt(col)));
                }
            }

            // x, y of start location is at index 1, e.g., 1 3
            Location start = matrix[parseInteger(data[1], 1)][parseInteger(data[1], 0)];
            start.setDescription(Location.Description.START);

            // x, y of end location is at index 2, e.g., 3 1
            Location end = matrix[parseInteger(data[2], 1)][parseInteger(data[2], 0)];
            end.setDescription(Location.Description.END);

            return new Maze(width, height, start, end, matrix);
        } catch (Exception e) {
            throw new Exception("Unable to parse the given file!");
        }
    }

    private int parseInteger(String line, int index) {
        return Integer.parseInt(line.split(" ")[index]);
    }

    private Location.Description parseDescription(char symbol) {
        return Integer.parseInt(String.valueOf(symbol)) == 1 ? Location.Description.WALL : Location.Description.PASSAGE;
    }
}
