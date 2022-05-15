import javax.swing.*;
import java.awt.*;

class ImagePanel extends JFrame {
    private final JPanel buttonPanel = new JPanel();
    Container con = getContentPane();

    public ImagePanel(){

        setTitle("Animal Trivia Game");
        setSize(650,500);
        setLocation(360,100);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setBackground();
        setVisible(true);
    }


    public void setBackground(){

        JLabel background = new JLabel(new ImageIcon("src/Assets/test.jpeg"));
        con.add(background);
        con.setLayout(new FlowLayout());
        con.add(buttonPanel);

    }

    public void setButton(JButton button){
        Font but = new Font("Serif" , Font.ITALIC , 20);
        button.setFont(but);
        buttonPanel.add(button);
        validate();
    }
}