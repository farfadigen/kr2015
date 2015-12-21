import java.awt.*;

/**
 * Created by user on 2015-12-21.
 */
public class Player {

    private Rectangle hitBox;

    public Player(int x, int y, int width, int height){
        hitBox = new Rectangle(x,y,width,height);
    }

    public void moveOn_X_Axis(int speed){
        hitBox.x += speed;
    }

    public void render(Graphics g){
        //g.setColor(new Color(200,200,200));
        g.fillRect(hitBox.x, hitBox.y, hitBox.width, hitBox.height);
    }
}
