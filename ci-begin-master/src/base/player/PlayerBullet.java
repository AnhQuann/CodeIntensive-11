package base.player;

import base.GameObject;
import tklibs.SpriteUtils;

public class PlayerBullet extends GameObject {
    public PlayerBullet() {
        super();
        this.image = SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
    }

    @Override
    public void run() {
        this.position.addThis(0, -8);
    }
}
