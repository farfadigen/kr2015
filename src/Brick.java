import java.awt.*;

/**
 * Created by user on 2015-12-22.
 */
public class Brick {
    private boolean isDisposed = false;
    private Rectangle brick;

    public Brick(int x, int y, int width, int height){
        brick = new Rectangle(x,y,width,height);
    }

    public boolean collide(Rectangle object){
        if (!isDisposed){return brick.intersects(object.x, object.y, object.width, object.height);}
        else{return false;}
    }

    /*public boolean collide(int x,int y,int radius) {
        if (!isDisposed) {
            if(x >= brick.x && x <= brick.x+brick.width || (x+radius*2) >= brick.x && (x+radius*2) <= brick.x+brick.width){

                return true;
            }
        } else {return false;}
    }*/

    public void dispose(){
        isDisposed=true;
    }

    public void draw(Graphics g){
        if(!isDisposed) {
            g.setColor(new Color(155, 50, 25));
            g.fillRect(brick.x, brick.y, brick.width, brick.height);
            g.setColor(new Color(0, 0, 0));
            g.drawRect(brick.x, brick.y, brick.width, brick.height);
        }
    }
}