import javax.swing.*;
import java.io.*;

/**
 * Created by user on 2015-12-21.
 */
public class Main {

    private static JFrame frame;
    private static Arkane arkane;
    private static Menu menu;

    public static void main(String[] args){
        frame = new JFrame("Arkane");
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        arkane = new Arkane(frame);
        arkane.setSize(frame.getSize());
        frame.add(arkane);

        File file = new File("src/OST.wav");
        Sound sound = new Sound(file);
        sound.setVolume((float)0.7);
        sound.play();
    }
}
