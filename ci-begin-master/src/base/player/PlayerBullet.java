package base.player;

import base.GameObject;
import base.Vector2D;
import base.enemy.Enemy;
import base.game.Setting;
import base.renderer.AnimationRenderer;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBullet extends GameObject {

    public PlayerBullet() {
        super();
        this.velocity.set(0, -5);
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
    }

    private void destroyNeeded() {
        if (this.position.y < -20 || this.position.y >= Setting.SCREEN_HEIGHT ||
                this.position.x < 0 || this.position.x >= Setting.BACKGROUND_WIDTH) {
            this.destroy();
        }
    }
}
