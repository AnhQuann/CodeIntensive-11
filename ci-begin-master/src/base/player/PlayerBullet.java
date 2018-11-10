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
        this.createRenderer();
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
        Vector2D enemy = gameObjects.get(2).position;
        this.position.substractThis((this.position.x - enemy.x)/10, (this.position.y - enemy.y)/10);

        if (this.position.y < -20){
            this.destroy();
        }
        if (this.position.y > Setting.SCREEN_HEIGHT) {
            this.destroy();
        }
        if (this.position.x < -20){
            this.destroy();
        }
        if (this.position.x > Setting.SCREEN_WIDTH) {
            this.destroy();
        }
    }
}
