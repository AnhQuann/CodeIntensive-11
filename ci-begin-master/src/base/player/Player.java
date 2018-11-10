package base.player;

import base.FrameCounter;
import base.game.GameCanvas;
import base.GameObject;
import base.KeyEventPress;
import base.renderer.AnimationRenderer;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject {
    FrameCounter fireCounter;
    public Player() {
        super();
        this.createRenderer();
        this.position.set(200,300);
        this.fireCounter = new FrameCounter(20);
    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = new SpriteUtils().loadImages(
                "assets/images/players/straight/0.png",
                "assets/images/players/straight/1.png",
                "assets/images/players/straight/2.png",
                "assets/images/players/straight/3.png",
                "assets/images/players/straight/4.png",
                "assets/images/players/straight/5.png",
                "assets/images/players/straight/6.png"
        );
        this.renderer = new AnimationRenderer(images);
    }

    @Override
    public void run() {
        if (KeyEventPress.isUpPress) {
           this.position.substractThis(0, 5);
        }
        if(KeyEventPress.isLeftPress) {
            this.position.substractThis(5, 0);
        }
        if(KeyEventPress.isDownPress) {
            this.position.addThis(0, 5);
        }
        if(KeyEventPress.isRightPress) {
            this.position.addThis(5, 0);
        }
        if(KeyEventPress.isFirePress) {
            this.fire();
        }
    }

    private void fire() {
        if (this.fireCounter.run()) {
            PlayerBullet bullet = GameObject.recycle(PlayerBullet.class);
            bullet.position.set(this.position);
            this.fireCounter.reset();
        }

    }
}
