import javax.swing.*;
import java.awt.event.*;
import java.io.File;

/**
 * Created by user on 2015-12-21.
 */
public class Main {

    private static JFrame frame;
    private static Arkane arkane;
    private static BallPanel menu;
    private static JButton gameStart;
    private static JButton addButton;
    private static JButton exitButton;

    public static void main(final String[] args){
        frame = new JFrame("Arkane");
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);

        menu = new BallPanel(frame);
        menu.setVisible(true);
        frame.add(menu);

        /*arkane = new Arkane(frame, menu);
        arkane.setSize(frame.getSize());
        arkane.setVisible(true);
        frame.add(arkane);*/

        gameStart = new JButton("Start Game");
        gameStart.setSize(150,30);
        gameStart.setLocation(325, 200);
        menu.add(gameStart);

        addButton = new JButton("Add ball");
        addButton.setSize(100,50);
        addButton.setLocation(650, 500);
        menu.add(addButton);

        exitButton = new JButton("Exit");
        exitButton.setSize(150,30);
        exitButton.setLocation(325, 350);
        menu.add(exitButton);

        gameStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.setVisible(false);
                arkane = new Arkane(frame, menu);
                arkane.setSize(frame.getSize());
                arkane.setVisible(true);
                frame.add(arkane);
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.addBall();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        File file = new File("src/OST2.wav");
        Sound sound = new Sound(file);
        sound.setVolume((float)0.7);
        sound.play();
    }
}
