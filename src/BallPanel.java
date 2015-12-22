import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by user on 2015-12-21.
 */
public class BallPanel extends JPanel {

    private ArrayList<Ball> balls = new ArrayList<Ball>();
    private Player player;

    /*BallPanel(){
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    player.moveOn_X_Axis(10);
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    player.moveOn_X_Axis(10);
                }
            }
        });
    }*/

    public void add(Ball b){
        balls.add(b);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        /*player = new Player(350,500,100,10);
        player.render(g);*/
        Graphics2D g2 = (Graphics2D) g;
        for(int i=0;i<balls.size();i++){
            Ball b = (Ball)balls.get(i);
            b.draw(g2);
        }
    }
}
