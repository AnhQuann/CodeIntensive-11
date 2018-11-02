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
    public static ArrayList<PlayerBullet> bullets;
    public static ArrayList<Enemy> enemies;
    public static ArrayList<EnemyBullet> enemyBullets;

    public GameCanvas() {
        this.background = new Background();
        this.player = new Player();
        GameCanvas.bullets = new ArrayList<>();
        GameCanvas.enemies = new ArrayList<>();
        GameCanvas.enemyBullets = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        this.background.render(g);
        this.player.render(g);
        for (PlayerBullet bullet:bullets) {
            bullet.render(g);
        }
        for (Enemy enemy:enemies) {
            enemy.render(g);
        }
        for (EnemyBullet enemyBullet:enemyBullets) {
            enemyBullet.render(g);
        }

    }
    public void gameLoop() {

        int delay = 1000 / 60;
        long lastRun = 0;
        int count = 30;
        while (true) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastRun > delay) {
                if (count > 50) {
                    Enemy enemy = new Enemy();
                    this.enemies.add(enemy);
                    EnemyBullet enemyBullet = new EnemyBullet();
                    enemyBullet.position.set(enemy.position.x, enemy.position.y);
                    this.enemyBullets.add(enemyBullet);
                    count = 0;
                } else {
                    count ++;
                }
                this.runAll();
                this.renderAll();
                lastRun = currentTime;
            }
        }
    }

    public void runAll() {
        this.background.run();
        this.player.run();
        for (PlayerBullet bullet : bullets) {
            bullet.run();
        }
        for (Enemy enemy:enemies) {
            enemy.run();
        }
        for (EnemyBullet enemyBullet: enemyBullets) {
            enemyBullet.run();
        }
    }

    public void renderAll() {
        this.repaint();
    }
}
