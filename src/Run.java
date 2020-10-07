/* This program is a simple rebuild for the popular mobile Flappy Bird
Author:
Jason Jiang 18043763
*/

import javax.swing.*;
import java.io.IOException;

//This is the main class that runs the game.
public class Run{
    public static  void main(String[] args) throws IOException {
        //set game window
        JFrame gameFrame = new JFrame();
        //set the resolution of the window
        gameFrame.setSize(430, 640);
        //create JPanel instance
        Game game = new Game();
        //add the instance to the frame
        gameFrame.add(game);
        //the window is at the center of the screen when it launches
        gameFrame.setLocationRelativeTo(null);
        //stop the process after exiting the application
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set visible
        gameFrame.setVisible(true);
        //call the action function
        game.action();
    }
}
