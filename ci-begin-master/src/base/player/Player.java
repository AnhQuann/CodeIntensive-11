package base.player;

import base.FrameCounter;
import base.action.Action;
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
    BoxCollider boxCollider;
    Action action;
    public Player() {
        super();
        this.createRenderer();
        this.position.set(200,300);
        this.action = new ActionFire();
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
        this.action.run(this);
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



    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
