package Model;

import View.gui;

public class NewGame {
    Maze maze;
    public NewGame(gui.Difficulty diff) {
        maze = new Maze(10, 10);

    }
}