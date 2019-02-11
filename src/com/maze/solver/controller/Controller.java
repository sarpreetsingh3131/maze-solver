package com.maze.solver.controller;

import com.maze.solver.model.Maze;
import com.maze.solver.model.MazeSolver;
import com.maze.solver.util.MazeParser;
import com.maze.solver.view.View;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Controller {

    public boolean play(MazeParser mazeParser, MazeSolver mazeSolver, View view, Scanner scanner) {
        String input;
        view.displayInstruction();
        input = scanner.nextLine();
        if (input.equals(view.getQUIT())) {
            return false;
        }
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(input)))) {
            Maze maze = mazeParser.parse(bufferedReader);
            boolean isSolved = mazeSolver.solve(maze);
            if (isSolved) {
                view.displaySolution(maze);
            } else {
                view.displayUnsolvedMessage();
            }
        } catch (Exception e) {
            view.displayError(e);
        }
        return true;
    }
}
