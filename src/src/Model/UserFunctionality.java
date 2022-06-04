package Model;

public class UserFunctionality {
    public static void main(String [] args){
        //create maze and generate
        createMaze();
        //print maze and display what directions are valid and moveable
    }

    public static void createMaze(){
        Maze maze = new Maze(5,5);
        maze.generateMaze();
        maze.convertMazeToLarger();

    }

    public enum Difficulty {
        EASY, MEDIUM, HARD, EXTREME
    }

    //method to display directions to move


    /*
    1. prompt user for direction and show the map and valid directions. for example doors only s and w, then show west and south are moveable
    2.
     */
}
