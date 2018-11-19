package base.player;

import base.FrameCounter;
import base.game.GameCanvas;
import base.GameObject;
import base.KeyEventPress;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.renderer.AnimationRenderer;
import base.renderer.SingleImageRenderer;
import com.sun.xml.internal.bind.v2.TODO;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject implements Physics {
    FrameCounter fireCounter;
    BoxCollider boxCollider;
    public Player() {
        super();
        this.createRenderer();
        this.position.set(200,300);
        this.fireCounter = new FrameCounter(20);
        this.boxCollider = new BoxCollider(this.position, 32, 48);
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
        this.move();
        if(this.fireCounter.run()) {
            if (KeyEventPress.isFirePress) {
                this.fire();
            }
        }
        super.run();
    }

    private void move() {
        //TODO upgrade
        int vx = 0;
        int vy = 0;
        if (KeyEventPress.isUpPress) {
            vy -= 5;
//            this.velocity.set(0, -5);
        }
        if(KeyEventPress.isLeftPress) {
            vx -= 5;
//            this.velocity.set(-5, 0);
        }
        if(KeyEventPress.isDownPress) {
            vy += 5;
//            this.velocity.set(0, 5);
        }
        if(KeyEventPress.isRightPress) {
            vx += 5;
//            this.velocity.set(5, 0);
        }
        this.velocity.set(vx, vy);
    }

    private void fire() {
        PlayerBulletType1 bullet = GameObject.recycle(PlayerBulletType1.class);
        bullet.position.set(this.position);

        PlayerBulletType2 bullet2 = GameObject.recycle(PlayerBulletType2.class);
        bullet2.position.set(this.position.add(-25, 0));
        bullet2.velocity.set(-5, -5);

//        PlayerBulletType2 bullet3 = GameObject.recycle(PlayerBulletType2.class);
//        bullet3.position.set(this.position.add(25, 0));
//        bullet3.velocity.set(5, -5);

        this.fireCounter.reset();
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
