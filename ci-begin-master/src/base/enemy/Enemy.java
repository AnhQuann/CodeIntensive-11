package base.enemy;

import base.Background;
import base.FrameCounter;
import base.GameObject;
import base.game.GameCanvas;
import base.renderer.AnimationRenderer;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject {
    FrameCounter fireCounter;
    public Enemy() {
        super();
        this.createRenderer();
        this.position.set(200, 100);
        this.fireCounter = new FrameCounter(20);
    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
                "assets/images/enemies/level0/blue/0.png",
                "assets/images/enemies/level0/blue/1.png",
                "assets/images/enemies/level0/blue/2.png",
                "assets/images/enemies/level0/blue/3.png"
        );
        this.renderer = new AnimationRenderer(images);
    }

    @Override
    public void run() {
        super.run();
//        this.position.addThis(0, 2);
        this.fire();
    }
    //TODO: replaceFrameCounter

    private void fire() {
        if (this.fireCounter.run()) {
            EnemyBullet enemyBullet = GameObject.recycle(EnemyBullet.class);
            enemyBullet.position.set(this.position);
            this.fireCounter.reset();
        }
    }
}

