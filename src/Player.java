import java.awt.*;

/**
 * Created by user on 2015-12-21.
 */
public class Player {

    private Rectangle hitBox;
    private Arkane arkane;

    public Player(Arkane ark, int x, int y, int width, int height){
        arkane = ark;
        hitBox = new Rectangle(x,y,width,height);
    }

    public void moveXAxis(int speed){
        hitBox.x += speed;
        if(hitBox.x<0){
            hitBox.x=0;
        }
        if(hitBox.x+hitBox.width>arkane.getWidth()){
            hitBox.x=arkane.getWidth()-hitBox.width;
        }
    }

    public int getX(){return hitBox.x;}

    public int getY(){return hitBox.y;}

    public int getWidth(){
        return hitBox.width;
    }

    public int getHeight(){
        return hitBox.height;
    }

    public boolean collide(Rectangle object){
        return hitBox.intersects(object.x, object.y, object.width, object.height);
    }

    public void draw(Graphics g){
        //g.setColor(new Color(200,200,200));
        g.fillRect(hitBox.x, hitBox.y, hitBox.width, hitBox.height);
    }
}
