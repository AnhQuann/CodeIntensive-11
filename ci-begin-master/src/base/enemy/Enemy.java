package base.enemy;

import base.Background;
import base.FrameCounter;
import base.GameObject;
import base.game.GameCanvas;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.renderer.AnimationRenderer;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject implements Physics {
    FrameCounter fireCounter;
    BoxCollider boxCollider;
    int hp;
    boolean immune;
    FrameCounter immuneCounter;

    public Enemy() {
        super();
        this.position.set(200, 100);
        this.velocity.set(0, 3);
        this.createRenderer();
        this.fireCounter = new FrameCounter(20);
        this.boxCollider = new BoxCollider(this.position, 32, 32);
        this.hp = 3;
        this.immune = false;
        this.immuneCounter = new FrameCounter(20);
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
        if (this.position.y >= 300) {
            this.velocity.set(0, 0);
        }
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

    public void takeDamage(int damage) {
        if (this.immune) {
            return;
        }
        this.hp -= damage;
        if (this.hp <= 0) {
            this.hp = 0;
            this.destroy();
        } else {
            this.immune = true;
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        EnemyExplosion explosion = GameObject.recycle(EnemyExplosion.class);
        explosion.position.set(this.position);
    }

    @Override
    public void reset() {
        super.reset();
        this.velocity.set(0,3);
        this.immune = false;
        this.immuneCounter.reset();
        this.hp = 3;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void render(Graphics g) {
        if (this.immune) {
            if (this.immuneCounter.run()){
                this.immune = false;
                this.immuneCounter.reset();
            }
            if (this.immuneCounter.count % 4 == 0){
                super.render(g);
            }
        } else {
            super.render(g);
        }
    }
}

