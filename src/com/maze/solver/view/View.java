package com.maze.solver.view;

import com.maze.solver.model.Location;
import com.maze.solver.model.Maze;

public class View {

    private final String QUIT = "q";

    public String getQUIT() {
        return QUIT;
    }

    public void displayInstruction() {
        System.out.print("Enter file path OR press " + QUIT + " to quit: ");
    }

    public void displayError(Exception e) {
        System.err.println(e.getMessage());
    }

    public void displayUnsolvedMessage() {
        System.out.println("The maze is unsolvable!");
    }

    public void displaySolution(Maze maze) {
        for (int row = 0; row < maze.getHeight(); row++) {
            for (int col = 0; col < maze.getWidth(); col++) {
                System.out.print(getDescriptionPrintValue(maze.getLocation(row, col).getDescription()));
            }
            System.out.println();
        }
    }

    private String getDescriptionPrintValue(Location.Description description) {
        switch (description) {
            case WALL:
                return "#";
            case PASSAGE:
                return " ";
            case START:
                return "S";
            case END:
                return "E";
            case PATH:
                return "X";
            default:
                return "";
        }
    }
}
