/* This program is a simple rebuild for the popular mobile Flappy Bird
Author:
Jason Jiang 18043763
*/

import javax.swing.JFrame;
import java.awt.*;
import java.io.IOException;

//This is the main class that runs the game.
public class Run{
    public static Game game;
    public static int WIDTH = 432;
    public static int HEIGHT = 644;

    public static  void main(String[] args) {
        //set game window
        JFrame frame = new JFrame();
        game = new Game();

        frame.add(game);
        frame.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Flappy Bird fake");
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        //System.out.println("YEEET");
    }
}
