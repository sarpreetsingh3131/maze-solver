package com.maze.solver;

import com.maze.solver.controller.Controller;
import com.maze.solver.model.MazeSolver;
import com.maze.solver.util.MazeParser;
import com.maze.solver.view.View;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        MazeParser mazeParser = new MazeParser();
        MazeSolver mazeSolver = new MazeSolver();
        View view = new View();
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller();
        while (controller.play(mazeParser, mazeSolver, view, scanner)) ;
        scanner.close();
    }
}
