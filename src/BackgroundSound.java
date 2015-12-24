/**
 * Created by user on 2015-12-24.
 */
public class BackgroundSound extends Thread {

    //private Sound sound;
    private String file;

    public BackgroundSound(String file){
        this.file = file;
    }

    public void run(){
        Sound.playSound(file,(float) 0.7).join();
    }
}