package Model;

import java.util.Scanner;

/**
 * Class for user functionality to move in maze.
 */
public class UserFunctionality {
    private static Maze maze;
    private static Scanner scan = new Scanner(System.in);
    private static Player myPlayer;
    public static void main(String [] args){
        //create maze and generate
        createMaze();
        //print maze and display what directions are valid and moveable
    }

    public static void createMaze(){
        maze = new Maze(5,5);
        myPlayer = new Player(5);
        maze.generateMaze();
        maze.convertMazeToLarger();
        maze.setQuestion();
        chooseDirection();
    }

    public static void chooseDirection(){

        boolean exit = false;
            outer: while(!exit){
                System.out.println("Choose one of the directions below");
                maze.displayDirections();
                char direction = scan.next().charAt(0);
                while(!checkIfMoveable(direction)){
                    System.out.println("Error: Choose one of the directions below");
                    maze.displayDirections();
                    direction = scan.next().charAt(0);
                }
                if(!maze.displayQuestion(direction)){
                    if(maze.checkTypeQuestionMaze(direction) == 0){
                        System.out.print("Enter Answer: ");
                        char answer = scan.next().charAt(0);
                        while(!maze.answerMultipleChoice(answer)){
                            myPlayer.decreaseHealth();
                            if(!myPlayer.alive()){
                                System.out.println("Game Over");
                                break outer;
                            }
                            System.out.println("Re-Enter Answer: ");
                            answer = scan.next().charAt(0);
                        }
                        maze.questionAnswered(direction);
                    }
                    else if(maze.checkTypeQuestionMaze(direction) == 1){
                        System.out.print("Enter Answer: ");
                        String answer = scan.next();
                        while(!maze.shortAnswer(answer)){
                            myPlayer.decreaseHealth();
                            if(!myPlayer.alive()){
                                System.out.println("Game Over");
                                break outer;
                            }
                            System.out.println("Re-Enter Answer: ");
                            System.out.println();
                            answer = scan.next();
                        }
                        maze.questionAnswered(direction);
                    }
                    else if(maze.checkTypeQuestionMaze(direction) == 2){
                        System.out.print("Enter True or False: ");
                        String answer = scan.next();
                        while(!maze.shortAnswer(answer)){
                            myPlayer.decreaseHealth();
                            if(!myPlayer.alive()){
                                System.out.println("Game Over");
                                break outer;
                            }
                            System.out.println("Re-Enter Answer: ");
                            System.out.println();
                            answer = scan.next();
                        }
                        maze.questionAnswered(direction);
                    }
                }
                maze.movePlayer(direction);
                maze.convertMazeToLarger();
                char quit = maze.checkUserSpot();
                if(quit == 'Q'){
                    System.out.println("You have reached the exit");
                    exit = true;
                }
            }
        }
//        else{
//            System.out.println("Choose one of the directions below");
//            maze.displayDirections();
//            direction = scan.next().charAt(0);
//            while(!checkIfMoveable(direction)){
//                System.out.println("Choose one of the directions below");
//                maze.displayDirections();
//                direction = scan.next().charAt(0);
//            }




    public static void reenter(){
        System.out.println("Choose one of the directions below");

    }
    //then display possible moves for doors and if user moves update spawn(player)
    //method to display directions to move


//        System.out.println("Choose Direction");
//        Scanner scan = new Scanner(System.in);
//        maze.displayDirections();
//        char direction = scan.next().charAt(0);
//        if(checkIfMoveable(direction)){
//            maze.movePlayer(direction);
//            char quit = maze.checkUserSpot();
//            while(direction != 'Q') {
//                if(quit == 'Q'){
//                    System.out.println("You have reached the exit");
//                    break;
//                }
//                maze.convertMazeToLarger();
//                System.out.println("Choose Direction");
//                maze.displayDirections();
//                direction = scan.next().charAt(0);
//                if(!checkIfMoveable(direction)){
//                    direction = scan.next().charAt(0);
//                }
//                maze.movePlayer(direction);
//                quit = maze.checkUserSpot();
//            }
//        }
//        else{
//            direction = scan.next().charAt(0);
//        }




    public static boolean checkIfMoveable(char theDirection){
        return maze.checkDirectionForUser(theDirection);
    }


}
