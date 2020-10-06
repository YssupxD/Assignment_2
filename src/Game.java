import java.awt.image.BufferedImage;
import java.io.IOException;

public class Game {
    public int state;//the variable that indicate the state of the game.
    public int score;

    //Game state
    public static final int START = 0;
    public static final int RUNNING = 1;
    public static final int GAMEOVER = 2;

    public BufferedImage backgroundImage = null;
    public BufferedImage startImage = null;
    public BufferedImage overIamge = null;


    Bird bird;
    Column c1;
    Column c2;
    Ground g;

    public Game() throws IOException {
        state = START;
        score = 0;
        //read the
    }
}
