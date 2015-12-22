import java.awt.*;

/**
 * Created by user on 2015-12-22.
 */
public class Shell {

    private Arkane arkane;
    private Dimension vector = new Dimension(0,0);
    private Point point;
    private int radius;

    public Shell(Arkane ark, int x, int y, int radius){
        arkane = ark;
        point = new Point(x, y);
        this.radius = radius;
    }

    public void setVector(int x,int y){vector = new Dimension(x,y);}

    public void setPosition(int x, int y){
        point = new Point(x,y);
    }

    public void tick(){
        if(point.x-radius<=0&&vector.width<0){vector.width=-vector.width;}
        if(point.x+radius>=arkane.getWidth()&&vector.width>0){vector.width=-vector.width;}
        if(point.y-radius<=0&&vector.height<0){vector.height=-vector.height;}
        if(point.y+radius>=arkane.getHeight()&&vector.height>0){arkane.lose();}

        if(arkane.getPlayer().collide(new Rectangle(point.x, point.y,radius*2,radius*2))){
            vector.height=-vector.height;
        }

        point.move(point.x+vector.width, point.y+vector.height);
    }

    public void render(Graphics g){
        g.setColor(new Color(0,0,0));
        g.fillOval(point.x-radius, point.y-radius, radius*2, radius*2);
    }
}
