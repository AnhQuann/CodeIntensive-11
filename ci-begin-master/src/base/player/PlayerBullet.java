package base.player;

import base.GameObject;
import base.Vector2D;
import base.enemy.Enemy;
import base.game.Setting;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.renderer.AnimationRenderer;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBullet extends GameObject implements Physics {
    BoxCollider boxCollider;
    int damage;
    public PlayerBullet() {
        super();
        this.velocity.set(0, -5);
        this.boxCollider = new BoxCollider(this.position, 24, 24);
        this.damage = 1;
    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
                "assets/images/player-bullets/a/0.png",
                "assets/images/player-bullets/a/1.png",
                "assets/images/player-bullets/a/2.png",
                "assets/images/player-bullets/a/3.png"
        );
        this.renderer = new AnimationRenderer(images);
    }

    @Override
    public void run() {
        super.run();
        this.destroyNeeded();
        this.hitEnemy();
    }

    private void hitEnemy() {
        Enemy enemy = GameObject.intersects(Enemy.class, this.boxCollider);
        if (enemy != null) {
            enemy.takeDamage(this.damage);
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
