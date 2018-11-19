package base.physics;

import base.Rectangle;
import base.Vector2D;

public class BoxCollider {
    public Vector2D masterPosition; //master == gameObjects
    public int width;
    public int height;

    public BoxCollider(Vector2D masterPosition, int width, int height) {
        this.masterPosition = masterPosition;
        this.width = width;
        this.height = height;
    }

    public int top() {
        return (int)this.masterPosition.y;
    }
    public int bot() {
        return (int)this.masterPosition.y + this.height;
    }
    public int left() {
        return (int)this.masterPosition.x;
    }
    public int right() {
        return (int) this.masterPosition.x + this.width;
    }

    public boolean intersects(BoxCollider other) {
        boolean intersectX = this.left() <= other.right() && other.left() <= this.right();
        boolean intersectY = this.top() <= other.bot() && other.top() <= this.bot();
        return intersectX && intersectY;
    }
}
