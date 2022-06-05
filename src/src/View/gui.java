package View;

import Model.Maze;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import static Model.UserFunctionality.Difficulty;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
/**
 * GUI class and main method for program
 *
 * @author Sophia Young
 */
public class gui {
    static Maze myMaze;
    static Clip myClip;
    static JFrame myGameFrame;

    public static void main(String[] theArgs) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
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
                loadLastGame();
                frame.setVisible(false);
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
        playMusic();
        frame.setButton(newGame);
        frame.setButton(loadGame);
        frame.setButton(exit);
    }

    private static void loadLastGame() {
        try{
            ObjectInputStream in=new ObjectInputStream(new FileInputStream("f.txt"));
            myMaze = new Maze(5, 5);
            myMaze.loadMaze(in);
            in.close();
            startNewGame(myMaze.getDiff());
        }catch(Exception e){System.out.println(e);}
    }

    private static void playMusic() {
        try {
            File music = new File("src/Assets/City Blocks - TrackTribe.wav");
            if(music.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(music);
                myClip = AudioSystem.getClip();
                myClip.open(audioInput);
                myClip.start();
                myClip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                System.out.println("error");
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }
    private static void muteUnmute() {
        if(myClip.isActive()) {
            myClip.stop();
        } else {
            myClip.start();
        }
    }

    static void startNewGame(Difficulty diff) {
        myGameFrame = new JFrame("Animal Trivia Maze");
        myGameFrame.setLayout(new GridBagLayout());
        myGameFrame.setLocation(360,100);
        myGameFrame.setSize(800, 600);
        myGameFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(11, 11));

        JPanel controlsPanel = new JPanel();
        controlsPanel.setLayout(new GridLayout(3, 3));
        setupControlPanel(controlsPanel);
        if(myMaze == null) {
            myMaze = new Maze(5, 5);
            myMaze.generateMaze();
            myMaze.convertMazeToLarger();
        }
        switch (diff) {
            case EASY -> {
                myMaze.setDiff(Difficulty.EASY);
                setupMaze(myMaze, gamePanel);
            }
            case MEDIUM -> {
                myMaze.setDiff(Difficulty.MEDIUM);
                setupMaze(myMaze, gamePanel);
            }
            case HARD -> {
                myMaze.setDiff(Difficulty.HARD);
                setupMaze(myMaze, gamePanel);
            }
            case EXTREME -> {
                myMaze.setDiff(Difficulty.EXTREME);
                setupMaze(myMaze, gamePanel);
            }
        }
        myGameFrame.add(gamePanel);
        myGameFrame.add(controlsPanel);
        myGameFrame.setVisible(true);
    }
    static void setupControlPanel(JPanel thePanel) {
        JButton up = new JButton();
        JButton down = new JButton();
        JButton left = new JButton();
        JButton right = new JButton();
        JButton save = new JButton("Save");
        JButton load = new JButton("Load");
        JButton mute = new JButton("Mute");
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
        left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Left Pressed");
            }
        });
        right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Right Pressed");
            }
        });
        down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Down Pressed");
            }
        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileOutputStream fout = new FileOutputStream("f.txt");
                    ObjectOutputStream out=new ObjectOutputStream(fout);
                    myMaze.saveMaze(out);
                } catch(Exception ex){System.out.println("error saving");}
            }
        });
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myGameFrame.setVisible(false);
                loadLastGame();

            }
        });
        mute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                muteUnmute();
            }
        });
        thePanel.add(blank);
        thePanel.add(up);
        thePanel.add(blank2);
        thePanel.add(left);
        thePanel.add(down);
        thePanel.add(right);
        thePanel.add(save);
        thePanel.add(load);
        thePanel.add(mute);
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
                thePanel.add(background);
            }
        }
    }
}
