import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.Key;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class Game extends JPanel implements ActionListener{
    public int state;//the variable that indicate the state of the game.
    public int score;

    //Game state
    public static final int START = 0;
    public static final int RUNNING = 1;
    public static final int GAMEOVER = 2;

    public BufferedImage backgroundImg = null;
    public BufferedImage startImg = null;
    public BufferedImage overImg = null;

    public Image[] _point =  new Image[10];;

   //public static AudioManagement am1 = new AudioManagement();
   // public static Clip clip_wing;

    //System
    AudioManagement am = new AudioManagement();

    Bird bird;
    Column c1;
    Column c2;
    Ground ground;

    public Game() throws IOException {
        state = START;
        score = 0;

        backgroundImg = ImageIO.read(new File("Resources/Images/bg.png"));
        startImg = ImageIO.read(new File("Resources/Images/start.png"));
        overImg = ImageIO.read(new File("Resources/Images/gameover.png"));

        setFocusable(true);

        bird = new Bird();
        c1 = new Column(1);
        c2 = new Column(2);
        ground = new Ground();




        KeyboardFocusManager.getCurrentKeyboardFocusManager()
                .addKeyEventDispatcher(new KeyEventDispatcher() {
                    @Override
                    public boolean dispatchKeyEvent(KeyEvent e) {
                        switch (e.getID()) {
                            case KeyEvent.KEY_PRESSED:
                                // keyEventSystem.KeyPressed(entities, e);
                                Key_Press(e);
                                // System.out.println("Pressed");
                                // GameEngine.this.keyPressed(e);
                                return true;
                            case KeyEvent.KEY_RELEASED:
                                // GameEngine.this.keyReleased(e);
                                return false;
                            case KeyEvent.KEY_TYPED:
                                // GameEngine.this.keyTyped(e);
                                return false;
                            default:
                                return false; // do not consume the event
                        }
                    }
                });

    }

    public void Key_Press(KeyEvent e) {
        if ((e.getKeyCode() == KeyEvent.VK_SPACE)) {
            switch(state) {
                case START:
                    bird.flyAnimation();
                    break;
                case RUNNING:
                    ground.step();
                    bird.flyAnimation();
                    c1.step();
                    c2.step();
                    bird.step();
                    //how we count the score, may add some collectives as feature.
                    if(bird.x == c1.x || bird.x == c2.x) {
                        score++;
                    }
                    //collision
                    if(bird.hit(c1) || bird.hit(c2) || bird.hit(ground)) {
                        state = GAMEOVER;
                    }
                    break;
            }
            repaint();
            try {
                Thread.sleep(1000 / 60);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
        //keyEventSystem.KeyReleased(entities, e);
    }



    public void paint(Graphics g) {
        //super.paint(g);
        g.drawImage(backgroundImg, 0, 0, null);
        //set font for score, need to be replace with the sprite sheet number
        //try to draw score img
        //make the bird rotate
        Graphics2D g2d = (Graphics2D) g;
        //rotate anti-clock wise
        g2d.rotate(-bird.rad, bird.x, bird.y);
        g.drawImage(bird.img, bird.x - bird.width / 2, bird.y - bird.height / 2, null);
        //rotate clock wise
        g2d.rotate(bird.rad, bird.x, bird.y);
        //paint the tubes
        g.drawImage(c1.img, c1.x - c1.width / 2, c1.y - c1.height / 2, null);
        g.drawImage(c2.img, c2.x - c2.width / 2, c2.y - c2.height / 2, null);
        //paint the ground
        g.drawImage(ground.img, ground.x, ground.y, null);
        if(state == RUNNING) {
            Score_display(g);
        }
        //paint game state(start menu and over menu)
        if(state == START) {
            g.drawImage(startImg, 0 , 0, null);
        }
        else if(state == GAMEOVER) {
            g.drawImage(overImg, 0, 0, null);
        }
    }


    //Mouse and Keyboard listener.
    public void action(){
        MouseListener ml = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                switch(state) {
                    case START:
                        state = RUNNING;
                        break;
                    case RUNNING:
                        bird.flyUp();
                        am.AudioManagement("Resources/Audios/wing.wav");
                        break;
                    case GAMEOVER:
                        am.AudioManagement("Resources/Audios/swoosh.wav");
                        state = START;
                        score = 0;
                        bird = new Bird();
                        c1 = new Column(1);
                        c2 = new Column(2);
                        ground = new Ground();
                        break;
                }
            }
        };
        this.addMouseListener(ml);
        while(true) {
            switch(state) {
                case START:
                    bird.flyAnimation();
                    break;
                case RUNNING:
                    ground.step();
                    bird.flyAnimation();
                    c1.step();
                    c2.step();
                    bird.step();
                    //how we count the score, may add some collectives as feature.
                    if(bird.x == c1.x || bird.x == c2.x) {
                        am.AudioManagement("Resources/Audios/point.wav");
                        score++;
                    }
                    //collision
                    if(bird.hit(c1) || bird.hit(c2) || bird.hit(ground)) {
                        am.AudioManagement("Resources/Audios/hit.wav");
                        am.AudioManagement("Resources/Audios/die.wav");
                        am.AudioManagement("Resources/Audios/swoosh.wav");
                        state = GAMEOVER;
                    }
                    break;
            }
            repaint();
            try {
                Thread.sleep(1000 / 60);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void Score_display(Graphics g){
        Image _final_point;
        try {
             //System.out.println("loading");
            _point[0] = ImageIO.read(new File("Resources/Images/num" + 0 + ".png"));
            _point[1] = ImageIO.read(new File("Resources/Images/num" + 1 + ".png"));
            _point[2] = ImageIO.read(new File("Resources/Images/num" + 2 + ".png"));
            _point[3] = ImageIO.read(new File("Resources/Images/num" + 3 + ".png"));
            _point[4] = ImageIO.read(new File("Resources/Images/num" + 4 + ".png"));
            _point[5] = ImageIO.read(new File("Resources/Images/num" + 5 + ".png"));
            _point[6] = ImageIO.read(new File("Resources/Images/num" + 6 + ".png"));
            _point[7] = ImageIO.read(new File("Resources/Images/num" + 7 + ".png"));
            _point[8] = ImageIO.read(new File("Resources/Images/num" + 8 + ".png"));
            _point[9] = ImageIO.read(new File("Resources/Images/num" + 9 + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //g.drawImage(_point[0], 100, 100, null);
        if(score<10){
            for(int j=0;j<10;j++) {
                if (score == j) {
                    g.drawImage(_point[j], 430/2, 100, null);
                }
            }
        }
        if(score>=10){
            String _score = Integer.toString(score);
            System.out.println("To string" + _score);
            char[] temp = _score.toCharArray();
            int s1 = Character.getNumericValue(temp[0]);
            int s2 = Character.getNumericValue(temp[1]);
            //System.out.println("a " + temp[0]+ " " +temp[1]);
            for(int a=0;a<10;a++) {
                if (s1 == a) {
                    g.drawImage(_point[a], 430/2, 100, null);
                }
            }
            for(int b=0;b<10;b++) {
                if ( s2 == b) {
                    g.drawImage(_point[b], 430/2+20, 100, null);
                }
            }
        }

    }

    public void action1(){

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
