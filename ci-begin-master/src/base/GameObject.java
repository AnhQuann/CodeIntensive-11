package base;

import base.player.Player;
import base.renderer.Renderer;
import com.sun.xml.internal.bind.v2.TODO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {
    //static
    public static ArrayList<GameObject> gameObjects = new ArrayList<>();
    public Player createPlayer() {
        Player player = new Player();
        gameObjects.add(player);
        return player;
    }

    public static <E extends GameObject> E create(Class<E> clazz) {
        try {
            E gameObject = clazz.newInstance();
            gameObjects.add(gameObject);
            return gameObject;
        } catch (Exception ex) {
            return null;
        }

    };

    public static <E extends GameObject> E recycle(Class<E> clazz) {
        for(GameObject gameObject: gameObjects) {
            if (isValidRecycle(gameObject, clazz)) {
                gameObject.reset();
                return (E)gameObject;
            }
        }
        E newGameObject = create(clazz);
        return newGameObject;
    }

    private static boolean isValidRecycle(GameObject gameObject, Class clazz) {
        //TODO
        return !gameObject.isActive && gameObject.getClass().isAssignableFrom(clazz);
    }

    public Vector2D position;
    public Renderer renderer;
    public boolean isActive;
    public Vector2D velocity;


    public GameObject() {
        this.position = new Vector2D();
        this.isActive = true;
        this.velocity = new Vector2D();
    }

    public void destroy() {
        this.isActive = false;
    }

    public void reset() {
        this.isActive = true;
    }

    public void run(){
        this.position.addThis(this.velocity);
    }

    public void render(Graphics g) {
        if (this.renderer != null) {
            this.renderer.render(g, this);
        }
    }

}
