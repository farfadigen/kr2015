import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by user on 2015-12-21.
 */
public class BallPanel extends JPanel {

    private ArrayList<Ball> balls = new ArrayList<Ball>();

    public void add(Ball b){
        balls.add(b);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for(int i=0;i<balls.size();i++){
            Ball b = (Ball)balls.get(i);
            b.draw(g2);
        }
    }
}
