import java.awt.*;

/**
 * Created by user on 2015-12-22.
 */
public class Shell {

    private Arkane arkane;
    private Dimension move = new Dimension(0,0);
    private Point point;
    private int radius;
    private int bricks;
    private int score=0;

    public Shell(Arkane ark, int x, int y, int radius){
        arkane = ark;
        point = new Point(x, y);
        this.radius = radius;
        Brick[][] bricks1 = ark.getWalls();
        bricks=bricks1.length*bricks1[0].length;
    }

    public void setVector(int x,int y){move = new Dimension(x,y);}

    public void setPosition(int x, int y){
        point = new Point(x,y);
    }

    public void tick(){
        if(point.x-radius<=0&&move.width<0){move.width=-move.width;}
        if(point.x+2*radius >= arkane.getWidth()&&move.width>0){move.width=-move.width;}
        if(point.y-radius<=0&&move.height<0){move.height=-move.height;}
        if(point.y+radius>=arkane.getHeight()&&move.height>0){arkane.lose();}

        if(arkane.getPlayer().collide(new Rectangle(point.x, point.y,radius*2,radius*2))){
            move.height=-move.height;
        }

        /*Player player = arkane.getPlayer();
        if(point.x >= player.getX() && point.x <= player.getX()+player.getWidth() || (point.x+radius*2) >= player.getX() && (point.x+radius*2) <= player.getX()+player.getWidth()){
            move.height=-move.height;
        }
        else if(point.y >= player.getY() && point.y <= player.getY()+player.getHeight() || (point.y+radius*2) >= player.getY() && (point.y+radius*2) <= player.getY()+player.getHeight()){
            move.width=-move.width;
        }*/

        point.move(point.x+move.width, point.y+move.height);
        for(Brick[] walls : arkane.getWalls()){
            for(Brick brick : walls){
                if(brick.collide(new Rectangle(point.x, point.y+move.height,radius*2,radius*2))){
                    brick.dispose();
                    score+=1;
                    bricks-=1; //System.out.println(bricks);
                    if(bricks==0){
                        arkane.win();
                    }
                    move.height=-move.height;
                }
            }
        }
    }

    public String getScore(){
        String c = ""+score;
        return c;
    }

    public void draw(Graphics g){
        g.setColor(new Color(0,0,0));
        g.fillOval(point.x-radius, point.y-radius, radius*2, radius*2);
    }
}
