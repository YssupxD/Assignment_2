import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Ground {
    int x = 0;
    int y = 500;
    BufferedImage img;

    public Ground() {
        try {
            img = ImageIO.read(getClass().getResource("/Resources/ground.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void step() {
        x--;
        if(x == -79) {
            x = 0;
        }
    }
}
