package View;

import Model.Maze;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
/**
 * GUI class and main method for program
 *
 * @author Sophia Young
 */
public class gui {

    public static void main(String[] theArgs) {
        ImageFrame frame = new ImageFrame();
        JButton newGame = new JButton("New Game");
        JButton loadGame = new JButton("Load Game");
        JButton exit = new JButton("Exit");

        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.hideMenu();
                JButton select = new JButton("Select Difficulty");
                select.setEnabled(false);
                JButton easy = new JButton("Easy");
                JButton medium = new JButton("Medium");
                JButton hard = new JButton("Hard");
                JButton extreme = new JButton("Extreme");
                frame.setButton(select);
                frame.setButton(easy);
                frame.setButton(medium);
                frame.setButton(hard);
                frame.setButton(extreme);
                easy.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        startNewGame(Difficulty.EASY);
                        frame.setVisible(false);
                    }
                });
                medium.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        startNewGame(Difficulty.MEDIUM);
                        frame.setVisible(false);
                    }
                });
                hard.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        startNewGame(Difficulty.HARD);
                        frame.setVisible(false);
                    }
                });
                extreme.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        startNewGame(Difficulty.EXTREME);
                        frame.setVisible(false);
                    }
                });
            }
        });
        loadGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println
                        ("load game pressed");
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
        frame.setButton(newGame);
        frame.setButton(loadGame);
        frame.setButton(exit);
    }
    static JPanel newGameMenu() {
        JPanel panel = new JPanel();
        String[] diff = { "Easy", "Medium", "Hard", "Extreme"};
        JComboBox<String> chooseDifficulty = new JComboBox<String>(diff);
        panel.add(new JLabel("Select Difficulty"));
        panel.add(chooseDifficulty);
        return panel;
    }
    static void startNewGame(Difficulty diff) {
        JFrame gameFrame = new JFrame("Animal Trivia Maze");
        gameFrame.setLayout(new FlowLayout());
        gameFrame.setLocation(360,100);
        gameFrame.setSize(1000, 800);
        gameFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(11, 11));

        JPanel controlsPanel = new JPanel();
        controlsPanel.setLayout(new GridLayout(2, 3));
        setupControlPanel(controlsPanel);
        Maze maze = new Maze(5, 5);;
        maze.generateMaze();
        maze.convertMazeToLarger();
        switch (diff) {
            case EASY -> {
                maze.setDiff(Difficulty.EASY);
                setupMaze(maze, gamePanel);
            }
            case MEDIUM -> {
                maze.setDiff(Difficulty.MEDIUM);
                setupMaze(maze, gamePanel);
            }
            case HARD -> {
                maze.setDiff(Difficulty.HARD);
                setupMaze(maze, gamePanel);
            }
            case EXTREME -> {
                maze.setDiff(Difficulty.EXTREME);
                setupMaze(maze, gamePanel);
            }
        }
        gameFrame.add(gamePanel);
        gameFrame.add(controlsPanel);
        gameFrame.setVisible(true);
    }
    static void setupControlPanel(JPanel thePanel) {
        JButton up = new JButton();
        JButton down = new JButton();
        JButton left = new JButton();
        JButton right = new JButton();
        JLabel blank = new JLabel(new ImageIcon("src/Assets/blank.jpg"));
        JLabel blank2 = new JLabel(new ImageIcon("src/Assets/blank.jpg"));
        up.setIcon(new ImageIcon("src/Assets/arrowUp.jpg"));
        up.setMargin(new Insets(0, 0, 0, 0));
        up.setBorder(null);
        left.setIcon(new ImageIcon("src/Assets/arrowLeft.jpg"));
        left.setMargin(new Insets(0, 0, 0, 0));
        left.setBorder(null);
        down.setIcon(new ImageIcon("src/Assets/arrowDown.jpg"));
        down.setMargin(new Insets(0, 0, 0, 0));
        down.setBorder(null);
        right.setIcon(new ImageIcon("src/Assets/arrowRight.jpg"));
        right.setMargin(new Insets(0, 0, 0, 0));
        right.setBorder(null);
        up.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Up Pressed");
            }
        });
        thePanel.add(blank);
        thePanel.add(up);
        thePanel.add(blank2);
        thePanel.add(left);
        thePanel.add(down);
        thePanel.add(right);
    }
    static void setupMaze(Maze theMaze, JPanel thePanel) {
        for (int i = 0; i < theMaze.getRows(); i++) {
            for(int j = 0; j < theMaze.getColumns(); j++) {
                char room = theMaze.getRoomType(i,j);
                JLabel background;
                if (room == 'W') {
                    background = new JLabel(new ImageIcon
                            ("src/Assets/wall.jpg"));
                } else if (room == 'R') {
                    background = new JLabel(new ImageIcon
                            ("src/Assets/room.jpg"));
                } else if (room == 'D') {
                    background = new JLabel(new ImageIcon
                            ("src/Assets/doorTEMP.jpg"));
                } else if (room == 'E') {
                    background = new JLabel(new ImageIcon
                            ("src/Assets/exit.jpg"));
                } else if (room == 'S') {
                    background = new JLabel(new ImageIcon
                            ("src/Assets/enter.jpg"));
                } else {
                    background = new JLabel(new ImageIcon
                            ("src/Assets/wall.jpg"));
                }
                //System.out.print(room + " ");
                thePanel.add(background);
            }
            //System.out.println();
        }
    }
    public enum Difficulty {
        EASY, MEDIUM, HARD, EXTREME
    }
}
