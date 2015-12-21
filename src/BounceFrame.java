import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by user on 2015-12-21.
 */
public class BounceFrame extends JFrame {

    private Player player;
    private BallPanel panel;
    public static final int DEFAULT_WIDTH = 800;
    public static final int DEFAULT_HEIGHT = 600;

    public BounceFrame(){
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setResizable(false);
        setTitle("BounceThread");

        Container contentPane = getContentPane();
        panel = new BallPanel(contentPane);

        contentPane.add(panel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "Start", new ActionListener(){
            public void actionPerformed(ActionEvent event){
                addBall();
            }
        });

        addButton(buttonPanel, "Close", new ActionListener(){
            public void actionPerformed(ActionEvent event){
                System.exit(0);
            }
        });

        contentPane.add(buttonPanel, BorderLayout.SOUTH);
    }

    public void addButton(Container c, String title, ActionListener listener){
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    public void addBall() {
        Ball ball = new Ball(panel);
        panel.add(ball);
        BallThread thread = new BallThread(ball);
        thread.start();
    }
}
