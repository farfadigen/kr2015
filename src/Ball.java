import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created by user on 2015-12-21.
 */
public class Ball {

    private BallPanel panel;
    private static final int XSIZE = 15;
    private static final int YSIZE = 15;
    private int x = 0;
    private int y = 0;
    private int dx = 5;
    private int dy = 5;

    public Ball(BallPanel c){panel = c;}

    public void draw(Graphics2D g2){g2.fill(new Ellipse2D.Double(x,y,XSIZE,YSIZE));}

    public void move(){
        x+=dx;
        y+=dy;
        if(x<0){
            x=0;
            dx=-dx;
        }
        if(x+XSIZE>=panel.getWidth()){
            x=panel.getWidth() - XSIZE;
            dx = -dx;
        }
        if(y < 0){
            y = 0;
            dy = -dy;
        }
        if(y + YSIZE >= panel.getHeight()){
            y = panel.getHeight() - YSIZE;
            dy = -dy;
        }
        panel.repaint();
    }
}
