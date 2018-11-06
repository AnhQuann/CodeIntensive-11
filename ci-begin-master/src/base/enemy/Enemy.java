package base.enemy;

import base.Background;
import base.GameObject;
import base.game.GameCanvas;
import base.renderer.AnimationRenderer;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject {
    public Enemy() {
        super();
//        Background background = new Background();
//        double width = (Math.random()*((background.image.getWidth() - 27 - 0) + 1)) + 0;
//        double height = (Math.random()*((100 - 0) + 1)) + 0;
//        BufferedImage image = SpriteUtils.loadImage("assets/images/enemies/level0/pink/0.png");;
//        this.renderer = new SingleImageRenderer(image);
        this.createRenderer();
        this.position.set(200, 100);
    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/blue/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/blue/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/blue/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/blue/3.png"));
        this.renderer = new AnimationRenderer(images);
    }

    @Override
    public void run() {
        super.run();
//        this.position.addThis(0, 2);
        this.fire();
    }
    int count = 0;
    private void fire() {
        if (count > 20) {
            EnemyBullet enemyBullet = new EnemyBullet();
            enemyBullet.position.set(this.position.x, this.position.y);
            GameCanvas.enemyBullets.add(enemyBullet);
            count = 0;
        } else {
            count++;
        }
    }
}

