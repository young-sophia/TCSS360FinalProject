import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class gui {
    public static void main(String[] theArgs) {
        JFrame frame = new JFrame("Animal Trivia Maze");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JLabel contentPane = new JLabel();
        Icon backgroundImage = new ImageIcon("src/Assets/test.jpeg");
        contentPane.setIcon( backgroundImage );
        contentPane.setLayout( new BorderLayout() );

        JButton newGame = new JButton("New Game");
        JButton loadGame = new JButton("Load Game");
        JButton exit = new JButton("Exit");

        panel.add(newGame);
        panel.add(loadGame);
        panel.add(exit);

        frame.setContentPane( contentPane );
        frame.add(panel);
        frame.setVisible(true);
    }
}