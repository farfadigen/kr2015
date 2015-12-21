/**
 * Created by user on 2015-12-21.
 */
public class BallThread extends Thread{

private Ball ball;

    public BallThread(Ball aBall){
        this.setDaemon(true);
        ball = aBall;
    }

    public void run(){
        try {
            while(true) {
                ball.move();
                sleep(5);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
