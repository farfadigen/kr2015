import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by user on 2015-12-21.
 */
public class Arkane extends JPanel{

    private Player player;

    public Arkane(Frame container){
        container.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    player.moveOn_X_Axis(10);
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    player.moveOn_X_Axis(-10);
                }
                repaint();
            }
        });
        player = new Player(350,500,100,10);
    }

    public void paint(Graphics g){
        super.paint(g);

        player.render(g);
    }
}
