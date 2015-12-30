import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by user on 2015-12-21.
 */
public class BallPanel extends JPanel {

    private ArrayList<Ball> balls = new ArrayList<Ball>();
    /*private JButton gameStart;
    private JButton addButton;
    private JButton exitButton;*/
    //private boolean isActive = true;

    BallPanel(final JFrame frame){
        setSize(frame.getSize());
        setLayout(null);

        addBall();

        /*gameStart = new JButton("Start Game");
        gameStart.setSize(150,30);
        gameStart.setLocation(325, 200);
        add(gameStart);

        addButton = new JButton("Add ball");
        addButton.setSize(100,50);
        addButton.setLocation(650, 500);
        add(addButton);

        exitButton = new JButton("Exit");
        exitButton.setSize(150,30);
        exitButton.setLocation(325, 350);
        add(exitButton);

        gameStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBall();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });*/
    }

    /*public boolean isActive(){
        return isActive;
    }

    public void setActive(boolean isActive){
        this.isActive = isActive;
    }*/

    public void addBall() {
        Ball ball = new Ball(this);
        add(ball);
        BallThread thread = new BallThread(ball);
        thread.setDaemon(true);
        thread.start();
    }

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