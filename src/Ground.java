import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Ground extends Game {
    int x = 0;
    int y = 500;
    BufferedImage img;
    public static Image back_ground;
    public Ground() {
        try {
            img = ImageIO.read(new File("Resources/Images/ground.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void load_Bg(){
        ImageIcon obj1 = new ImageIcon("Resources/bg.png");
        back_ground = obj1.getImage();
    }


    static void do_Drawing(Graphics g) {
        g.drawImage(back_ground, 0, 0, null);
    }

    public void step() {
        x--;
        if(x == -79) {
            x = 0;
        }
    }
}
