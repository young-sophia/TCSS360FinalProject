package Model;

import Controller.Player;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class UserFunctionality {
    private static Maze myMaze;
    private static Scanner scan = new Scanner(System.in);
    private static Player myPlayer;

    static String myQuestion;
    static String myQuestionString;
    static String myAnswer;

    public static void createMaze(){
        myMaze = new Maze(5,5);
        myPlayer = new Player(5);
        myMaze.generateMaze();
        myMaze.convertMazeToLarger();
        myMaze.setQuestion();
        //chooseDirection();
    }

    public static Maze getMaze() {
        return myMaze;
    }
    public static String getMyQuestionString() {
        return myQuestionString;
    }
    /*
    public static void chooseDirection(){
        boolean exit = false;
        outer: while(!exit){
            System.out.println("Choose one of the directions below");
            myMaze.displayDirections();
            char direction = Character.toUpperCase(scan.next().charAt(0));
            while(!checkIfMoveable(direction)){
                System.out.println("Error: Choose one of the directions below");
                myMaze.displayDirections();
                direction = Character.toUpperCase(scan.next().charAt(0));
            }
            if(!myMaze.displayQuestion(direction)){
                if(myMaze.checkTypeQuestionMaze(direction) == 0){
                    System.out.print("Enter Answer: ");
                    char answer = scan.next().charAt(0);
                    while(!myMaze.answerMultipleChoice(answer)){
                        myPlayer.decreaseHealth();
                        if(!myPlayer.alive()){
                            System.out.println("Game Over");
                            break outer;
                        }
                        System.out.println("Re-Enter Answer: ");
                        answer = scan.next().charAt(0);
                    }
                    myMaze.questionAnswered(direction);
                }
                else if(myMaze.checkTypeQuestionMaze(direction) == 1){
                    System.out.print("Enter Answer: ");
                    String answer = scan.next();
                    while(!myMaze.shortAnswer(answer)){
                        myPlayer.decreaseHealth();
                        if(!myPlayer.alive()){
                            System.out.println("Game Over");
                            break outer;
                        }
                        System.out.println("Re-Enter Answer: ");
                        System.out.println();
                        answer = scan.next();
                    }
                    myMaze.questionAnswered(direction);
                }
                else if(myMaze.checkTypeQuestionMaze(direction) == 2){
                    System.out.print("Enter True or False: ");
                    String answer = scan.next();
                    while(!myMaze.shortAnswer(answer)){
                        myPlayer.decreaseHealth();
                        if(!myPlayer.alive()){
                            System.out.println("Game Over");
                            break outer;
                        }
                        System.out.println("Re-Enter Answer: ");
                        System.out.println();
                        answer = scan.next();
                    }
                    myMaze.questionAnswered(direction);
                }
            }
            myMaze.movePlayer(direction);
            myMaze.convertMazeToLarger();
            char quit = myMaze.checkUserSpot();
            if(quit == 'Q'){
                System.out.println("You have reached the exit");
                exit = true;
            }
        }
    }
     */
    public static boolean chooseDirectionGUI(char theDirection) {
        myMaze.movePlayer(theDirection);
        char quit = myMaze.checkUserSpot();
        if (quit == 'Q') {
            System.out.println("You have reached the exit");
            return false;
        } else {
            return true;
        }
    }
    public static boolean checkIfMoveable(char theDirection){
        return myMaze.checkDirectionForUser(theDirection);
    }

    public static String getQuestionString() {
        myQuestion = myMaze.getQuestion();
        int type = myMaze.getQuestionType();
        String answer = myMaze.getAnswer();
        //String correctAnswer;
        System.out.println(type);
        if(type == 0) {
            String[] choice = answer.split(", ");
            myAnswer = choice[0];
            Collections.shuffle(Arrays.asList(choice));
            myQuestionString = myQuestion + "\nA. " + choice[0] + "\nB. " + choice[1] + "\nC. " + choice[2] + "\nD. " + choice[3];
        } else if (type == 1 || type == 2 || type == 3) {
            myAnswer = answer;
            myQuestionString = myQuestion + "\n" + answer;
        }
        System.out.println(myQuestion);
        return myQuestionString;
    }

    public static boolean checkAnswer(String givenAns) {
        if (myAnswer.equals(givenAns)) {
            //myMaze.questionAnswered();
            return true;
        } else{
            myPlayer.decreaseHealth();
            if (!myPlayer.alive()) {
                System.exit(2);
            }
            return false;
        }
    }

    public enum Difficulty {
        EASY, MEDIUM, HARD, EXTREME
    }

}
