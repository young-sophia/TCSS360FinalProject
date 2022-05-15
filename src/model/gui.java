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
        ImagePanel panel = new ImagePanel();

        JButton newGame = new JButton("New Game");
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startNewGame();
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

        panel.setButton(newGame);
        panel.setButton(loadGame);
        panel.setButton(exit);
    }

    static void startNewGame() {
        System.out.println("New Game Started!");
    }
}