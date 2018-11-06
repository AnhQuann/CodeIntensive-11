package base.game;

import base.Background;
import base.GameObject;
import base.enemy.Enemy;
import base.enemy.EnemyBullet;
import base.player.Player;
import base.player.PlayerBullet;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameCanvas extends JPanel {
    public GameObject background;
    public GameObject player;
    public GameObject enemy;
    public static ArrayList<PlayerBullet> bullets;
    public static ArrayList<EnemyBullet> enemyBullets;

    public GameCanvas() {
        this.background = new Background();
        this.player = new Player();
        this.enemy = new Enemy();
        GameCanvas.bullets = new ArrayList<>();
        GameCanvas.enemyBullets = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        this.background.render(g);
        this.player.render(g);
        this.enemy.render(g);
        for (PlayerBullet bullet:bullets) {
            bullet.render(g);
        }
        for (EnemyBullet enemyBullet:enemyBullets) {
            enemyBullet.render(g);
        }

    }
    public void gameLoop() {

        int delay = 1000 / 60;
        long lastRun = 0;
        while (true) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastRun > delay) {

                this.runAll();
                this.renderAll();
                lastRun = currentTime;
            }
        }
    }

    public void runAll() {
        this.background.run();
        this.player.run();
        this.enemy.run();
        for (PlayerBullet bullet : bullets) {
            bullet.run();
        }
//        }
        for (EnemyBullet enemyBullet: enemyBullets) {
            enemyBullet.run();
        }
    }

    public void renderAll() {
        this.repaint();
    }
}
