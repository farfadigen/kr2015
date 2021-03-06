import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by user on 2015-12-21.
 */
public class Arkane extends JPanel{

    private Player player;
    private Shell shell;
    private boolean isRunning = false;
    //private boolean isActive = false;
    private Brick brick;
    private Brick[][] walls;

    public Arkane(final JFrame game, final JFrame frame){
        game.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(!isRunning){
                    if(e.getKeyCode() == KeyEvent.VK_SPACE){
                        if(!isRunning&&!arkThread.isAlive()){start();}
                        else if(!isRunning&&arkThread.isAlive()){
                            game.setVisible(false);
                            frame.setVisible(true);
                        }
                    }
                }
                else {
                    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                        player.moveXAxis(30);
                    }
                    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                        player.moveXAxis(-30);
                    }
                    repaint();
                }
            }
        });

        walls = new Brick[15][3];
        for(int i=0;i<walls.length;i++){
            for(int j=0;j<walls[i].length;j++){
                walls[i][j] = new Brick(50*i+(800-50*walls.length)/2,25*j,50,25);
            }
        }

        player = new Player(this, 350,500,100,10);
        shell = new Shell(this, 100,100,7);

        arkThread = new Thread(new Runnable() {
            @Override
            public void run() {
                shell.setVector(4,4);
                synchronized (this){
                    while(true){
                        if(isRunning){
                            shell.tick();
                            repaint();
                            try {
                                Thread.sleep(17);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        else{
                            try {
                                wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
    }

    public void start(){
        arkThread.setDaemon(true);
        arkThread.start();
        isRunning=true;
    }

    public void resume(){
        arkThread.notify();
    }

    public void pause(){
        isRunning=false;
    }

    public Player getPlayer(){
        return player;
    }

    /*public boolean isActive(){
        return isActive;
    }

    public void setActive(boolean isActive){
        this.isActive = isActive;
    }*/

    public Brick[][] getWalls(){return walls;}

    public void lose(){
        pause();
        JLabel icon = new JLabel(new javax.swing.ImageIcon(getClass().getResource("wasted.jpeg")));
        icon.setSize(600,350);
        icon.setVisible(true);
        icon.setLocation(100,100);
        add(icon);

    }

    public void win(){
        pause();
        JLabel icon = new JLabel(new javax.swing.ImageIcon(getClass().getResource("win.png")));
        icon.setSize(600,350);
        icon.setVisible(true);
        icon.setLocation(100,100);
        add(icon);
    }

    public void paint(Graphics g){
        super.paint(g);

        setBackground(Color.WHITE);

        for(int i=0;i<walls.length;i++){
            for(int j=0;j<walls[i].length;j++){
                walls[i][j].draw(g);
            }
        }

        if(!isRunning&&!arkThread.isAlive()){g.drawString("Press SPACE to start",345,550);}
        if(!isRunning&&arkThread.isAlive()){
            g.drawString("Your score: "+shell.getScore(),345,540);
            g.drawString("Press SPACE to return",345,560);
        }
        player.draw(g);
        shell.draw(g);
    }

    private Thread arkThread;
}