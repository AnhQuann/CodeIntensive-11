package base;

import base.game.Setting;
import tklibs.SpriteUtils;

public class Background extends GameObject {
    public Background() {
        super();
        this.image = SpriteUtils.loadImage("assets/images/background/0.png");
        this.position.set(0, Setting.SCREEN_HEIGHT -this.image.getHeight());

    }

    @Override
    public void run() {
        if (this.position.y < 0) {
            this.position.addThis(0, 10);
        }
    }
}