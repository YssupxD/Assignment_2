import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Ground {
    int x = 0;
    int y = 500;
    BufferedImage img;

    public Ground() {
        try {
            img = ImageIO.read(new File("Resources/Images/ground.png"));
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
