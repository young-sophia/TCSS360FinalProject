import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class gui {
    public static void main(String[] theArgs) {
        ImagePanel panel = new ImagePanel();
        JButton newGame = new JButton("New Game");
        JButton loadGame = new JButton("Load Game");
        JButton exit = new JButton("Exit");

        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.hideMenu();
                JButton select = new JButton("Select Difficulty");
                select.setEnabled(false);
                JButton easy = new JButton("Easy");
                JButton medium = new JButton("Medium");
                JButton hard = new JButton("Hard");
                JButton extreme = new JButton("Extreme");
                panel.setButton(select);
                panel.setButton(easy);
                panel.setButton(medium);
                panel.setButton(hard);
                panel.setButton(extreme);
                easy.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        startNewGame(1);
                        panel.setVisible(false);
                    }
                });
                medium.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        startNewGame(2);
                        panel.setVisible(false);
                    }
                });
                hard.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        startNewGame(3);
                        panel.setVisible(false);
                    }
                });
                extreme.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        startNewGame(4);
                        panel.setVisible(false);
                    }
                });
            }
        });
        loadGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("load game pressed");
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
        panel.setButton(newGame);
        panel.setButton(loadGame);
        panel.setButton(exit);
    }
    static JPanel newGameMenu() {
        JPanel panel = new JPanel();
        String[] diff = { "Easy", "Medium", "Hard", "Extreme"};
        JComboBox<String> chooseDifficulty = new JComboBox<String>(diff);
        panel.add(new JLabel("Select Difficulty"));
        panel.add(chooseDifficulty);
        return panel;
    }
    static void startNewGame(int theDifficulty) {
        System.out.println("New Game Started!");
        JFrame gameFrame = new JFrame("Animal Trivia Maze");
        gameFrame.setLocation(360,100);
        gameFrame.setSize(800, 800);
        gameFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gameFrame.setVisible(true);
    }
}