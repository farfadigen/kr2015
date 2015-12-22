import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by user on 2015-12-21.
 */
public class Arkane extends JPanel{

    private Player player;
    private Shell shell;
    private boolean isRunning = false;

    public Arkane(Frame container){
        container.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(!isRunning){
                    if(e.getKeyCode() == KeyEvent.VK_SPACE){start();}
                }
                else {
                    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                        player.moveOn_X_Axis(10);
                    }
                    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                        player.moveOn_X_Axis(-10);
                    }
                    //repaint();
                }
            }
        });
        player = new Player(this, 350,500,100,10);
        shell = new Shell(this, 20,20,7);
        arkThread = new Thread(new Runnable() {
            @Override
            public void run() {
                shell.setVector(10,10);
                synchronized (this){
                    while(true){
                        if(isRunning){
                            shell.tick();
                            repaint();
                            try {
                                Thread.sleep(50);
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

    public void lose(){
        pause();
        JLabel icon = new JLabel(new javax.swing.ImageIcon(getClass().getResource("wasted.jpeg")));
        icon.setSize(350,350);
        icon.setVisible(true);

        add(icon);
    }

    public void paint(Graphics g){
        super.paint(g);

        setBackground(Color.WHITE);

        player.render(g);
        shell.render(g);
    }

    private Thread arkThread;
}
