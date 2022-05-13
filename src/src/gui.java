import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class gui {
    public static void main(String[] theArgs) {
        JFrame frame = new JFrame("Animal Trivia Maze");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        //JLabel contentPane = new JLabel();
        //ImageIcon backgroundImage = new ImageIcon("src/Assets/test.jpeg");
        //contentPane.setIcon( backgroundImage );
        //contentPane.setLayout( new BorderLayout() );

        JButton newGame = new JButton("New Game");
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("new game pressed");
            }
        });
        JButton loadGame = new JButton("Load Game");
        loadGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("load game pressed");
            }
        });
        JButton exit = new JButton("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("exit game pressed");
            }
        });

        JLabel title = new JLabel("Animal Trivia Maze", SwingConstants.CENTER);
        title.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));

        panel.add(newGame);
        panel.add(loadGame);
        panel.add(exit);

        //frame.setContentPane( contentPane );
        frame.getContentPane().add(BorderLayout.NORTH, title);
        frame.getContentPane().add(BorderLayout.CENTER,panel);
        frame.setVisible(true);
    }
}