import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Bird {
    int x, y;
    BufferedImage img;
    static final int size = 40;

    int width, height;
    BufferedImage[] imgs = new BufferedImage[8];
    int index = 0;

    double s;
    double t;
    static final double g = 9.8;//acceleration of gravity
    static final double v0 = 20;//speed at the beginning
    double speed;//current speed

    double rad;//the angle rotate when the bird jumps.

    public Bird() throws IOException {
        x = 140;
        y = 220;
        t = 0.25;
        speed = v0;

        // load the bird image.
        try {
            img = ImageIO.read(getClass().getResource("/Resources/0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        width = img.getWidth();
        height = img.getHeight();

        //An array to store all the bird images.
        for(int i = 0; i < 8; i++) {
            imgs[i] = ImageIO.read(getClass().getResource("/Resources/" + i +".png"));
        }
    }

    public void flyAnimation() {
        index++;
        img = imgs[(index / 8) % 8];
    }

    public void hopAnimation() {
        double v = speed;
        s = v * t - g * t * t;
        y = (int) (y - s);
        speed = v - g * t;
        rad = Math.atan(s / 8);
    }

    public void flyup() {
        speed = v0;
    }

    public boolean hit()
}
