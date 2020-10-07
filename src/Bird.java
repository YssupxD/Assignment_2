import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bird extends Game {
    //public static int x, y;
    BufferedImage img;
    static final int size = 40;

    int width, height;
    static BufferedImage[] imgs = new BufferedImage[8];
    public static Image Bird_Img;//temporary img to load bird
    int index = 0;

    double s;
   // double t;
    static final double g = 9.8;//acceleration of gravity
    static final double v0 = 20;//speed at the beginning
    //double speed;//current speed

    double rad;//the angle rotate when the bird jumps.

    public static void Draw_Bird() {
        Game.x = 140;
        Game.y = 220;
        //t = 0.25;
       // speed = v0;

        // load the bird image.
        try {
            //System.out.println("Loading");
            Bird_Img = ImageIO.read(new File("Resources/0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

      //  width = img.getWidth();
        //height = img.getHeight();

        //An array to store all the bird images.
       /* try {
            for(int i = 0; i < 8; i++) {
                imgs[i] = ImageIO.read(new File("/Resources/" + i +".png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/ //Just commenting out for later trying to making it shows up first
    }

    public void flyAnimation() {//
        index++;
        img = imgs[(index / 8) % 8];
    }

    public void step() {// The animation every time the bird hops (mouse clicked or space key got pressed)
        //double v = speed;
        //s = v * t - g * t * t;
        //y = (int) (y - s);
        //speed = v - g * t;
        rad = Math.atan(s / 8);
    }

    public void flyup() {
        y = +10;
    }

    public boolean hit(Column c) {//the collision between the bird and the column
        if(x > c.x - size / 2 - c.width / 2 && x < c.x + c.width / 2 + size / 2) {
            if(y > c.y - c.gap / 2 + size / 2 && y < c.y + c.gap / 2 - size / 2) {
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean hit(Ground g) {//the collision between the bird and the column
        if(y >= g.y - size / 2) {
            rad = -Math.PI / 2;
            return true;
        }
        return false;
    }
}
