import base.game.GameCanvas;
import base.game.GameWindow;

/**
 * Created by huynq on 7/4/17.
 */
public class Program {
    public static void main(String[] args) {
        GameWindow window = new GameWindow();
        GameCanvas canvas = new GameCanvas(); // init canvas
        window.add(canvas); // add canvas to window
        window.setResizable(false);
        canvas.gameLoop();
    }
}
