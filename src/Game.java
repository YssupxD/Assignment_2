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


public class Game extends JPanel implements Runnable, ActionListener, KeyListener {
    public int state;//the variable that indicate the state of the game.
    public int score;

    public static int x,y;
    //Game state
    public static final int START = 0;
    public static final int RUNNING = 1;
    public static final int GAMEOVER = 2;
    public static Timer timer;

    public Ground _ground;
    public int DELAY = 100;
    
    public boolean Game_running = true;

    public Game(){
        Timer timer = new Timer(DELAY, this);
        Ground.load_Bg();
        Bird.Draw_Bird();
        timer.start();

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        do_Drawing(g);
    }
    private void do_Drawing(Graphics g){
        g.drawImage(Ground.back_ground,0,0,null);
        g.drawImage(Bird.Bird_Img,130,230,null);
    }
    public void run() {
        // todo auto generated method
        while(Game_running) {
            update();
        }
          //  render();
        //}
    }

    private void update() {
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            System.out.println("Ya Yeeettt");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
