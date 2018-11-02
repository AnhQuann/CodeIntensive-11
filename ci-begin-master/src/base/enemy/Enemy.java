package base.enemy;

import base.Background;
import base.GameObject;
import base.game.GameCanvas;
import tklibs.SpriteUtils;

public class Enemy extends GameObject {
    public Enemy() {
        super();
        Background background = new Background();
        double width = (Math.random()*((background.image.getWidth() - 27 - 0) + 1)) + 0;
        double height = (Math.random()*((100 - 0) + 1)) + 0;
        this.image = SpriteUtils.loadImage("assets/images/enemies/level0/pink/0.png");
        this.position.set(Math.round(width), Math.round(height));
    }

    @Override
    public void run() {
        this.position.addThis(0, 2);

    }
}

