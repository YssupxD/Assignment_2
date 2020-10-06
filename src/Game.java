import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Game extends JPanel implements Runnable, ActionListener {
    public int state;//the variable that indicate the state of the game.
    public int score;

    //Game state
    public static final int START = 0;
    public static final int RUNNING = 1;
    public static final int GAMEOVER = 2;
    public static Timer timer;
    public int DELAY = 100;

    public Game(){
        Timer timer = new Timer(DELAY, this);
        Ground.load_Bg();
        timer.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        do_Drawing(g);
    }
    private void do_Drawing(Graphics g){
        g.drawImage(Ground.back_ground,0,0,null);
    }
    public void run() {
        // todo auto generated method
        //while(Game_running) {
            //update();
          //  render();
        //}
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
