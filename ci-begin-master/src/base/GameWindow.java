package base;

import javax.swing.*;

public class GameWindow extends JFrame {
    public GameWindow() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(800, 600);
        this.setTitle("Game Toohoo");
         // cannot resize window
    }
}
