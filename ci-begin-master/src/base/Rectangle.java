package base;

public class Rectangle {
    Vector2D position;
    int width;
    int height;

    public Rectangle() {
        this(new Vector2D(), 5, 5);
    }

    public Rectangle(Vector2D position, int width, int height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public int top() {
        return (int)this.position.y;
    }
    public int bot() {
        return (int)this.position.y + this.height;
    }
    public int left() {
        return (int)this.position.x;
    }
    public int right() {
        return (int) this.position.x + this.width;
    }

    public boolean intersects(Rectangle other) {
        boolean intersectX = this.left() <= other.right() && other.left() <= this.right();
        boolean intersectY = this.top() <= other.bot() && other.top() <= this.bot();
        return intersectX && intersectY;
    }

    public static void main(String[] args) {
        Rectangle rec1 = new Rectangle(new Vector2D(0, 0), 10, 10);
        Rectangle rec2 = new Rectangle(new Vector2D(5, 5), 10, 10);
        Rectangle rec3 = new Rectangle(new Vector2D(5, -15), 10, 10);
        System.out.println(rec1.intersects(rec2));
        System.out.println(rec2.intersects(rec3));
        System.out.println(rec1.intersects(rec3));
    }
}
