package base;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameObject {

    public BufferedImage image;
    public Vector2D position;
    public GameObject() {
        this.position = new Vector2D();
    }

    public void run(){

    }

    public void render(Graphics g) {
        g.drawImage(this.image, (int) this.position.x, (int)this.position.y, null);
    }

}
