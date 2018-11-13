package base.enemy;

import base.GameObject;
import base.game.GameCanvas;
import base.game.Setting;
import base.renderer.SingleImageRenderer;
import com.sun.scenario.Settings;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class EnemyBullet extends GameObject {
    public EnemyBullet() {
        super();
        BufferedImage image = SpriteUtils.loadImage("assets/images/enemies/bullets/green.png");
        this.renderer = new SingleImageRenderer(image);
        this.velocity.set(0, 5);
    }

    @Override
    public void run() {
        super.run();
        this.destroyNeeded();
//        this.position.addThis(0, 7);
//        if (this.position.y < -20){
//            this.destroy();
//        }
//        if (this.position.y > Setting.SCREEN_HEIGHT) {
//            this.destroy();
//        }
//        if (this.position.x < -20){
//            this.destroy();
//        }
//        if (this.position.x > Setting.SCREEN_WIDTH) {
//            this.destroy();
//        }
    }

    private void destroyNeeded() {
        if (this.position.y < -20 || this.position.y >= Setting.SCREEN_HEIGHT ||
                this.position.x < 0 || this.position.x >= Setting.BACKGROUND_WIDTH) {
            this.destroy();
        }
    }

}
