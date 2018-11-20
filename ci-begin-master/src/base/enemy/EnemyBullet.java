package base.enemy;

import base.GameObject;
import base.game.GameCanvas;
import base.game.Setting;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.player.Player;
import base.renderer.BoxRenderer;
import base.renderer.SingleImageRenderer;


import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EnemyBullet extends GameObject implements Physics {
    BoxCollider boxCollider;
    public EnemyBullet() {
        super();
//        BufferedImage image = SpriteUtils.loadImage("assets/images/enemies/bullets/green.png");
//        this.renderer = new SingleImageRenderer(image);
        this.boxCollider = new BoxCollider(this.position, 16, 16);
        this.velocity.set(0, 5);
        this.renderer = new BoxRenderer(this.boxCollider, Color.GREEN, false);
    }

    @Override
    public void run() {
        super.run();
        this.destroyNeeded();
        this.hitPlayer();
    }

    private void hitPlayer() {
        Player player = GameObject.intersects(Player.class, this.boxCollider);
        if (player != null) {
            player.destroy();
            this.destroy();
        }
    }

    private void destroyNeeded() {
        if (this.position.y < -20 || this.position.y >= Setting.SCREEN_HEIGHT ||
                this.position.x < 0 || this.position.x >= Setting.BACKGROUND_WIDTH) {
            this.destroy();
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

}
