import javax.swing.*;

/**
 * Created by user on 2015-12-21.
 */
public class Main {

    private static JFrame frame;
    private static Arkane arkane;

    public static void main(String[] args){
        frame = new JFrame("Arkane");
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);

        arkane = new Arkane(frame);
        arkane.setSize(frame.getSize());
        frame.add(arkane);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
