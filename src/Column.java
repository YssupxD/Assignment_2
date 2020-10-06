import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Column {
    int x, y;
    int width, height;
    BufferedImage img;
    static final int distance = 245; //distance between columns.
    static final int gap = 144; //gap between upper column and lower column
    Random r = new Random();

    public Column(int n) throws IOException {
        img = ImageIO.read(getClass().getResource("/Resources/column.png"));
        width = img.getWidth();
        height = img.getHeight();

        x = (n - 1) * distance + 500;
        y = r.nextInt(218) + 132;
    }

    public void step() {
        x--;
        if(x == -width / 2) {
            x = distance * 2 - width / 2;
            y = r.nextInt(218) + 132;
        }
    }
}
