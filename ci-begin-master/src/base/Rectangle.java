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

    public boolean intersects(Rectangle other) {
        float left1 = this.position.x - this.width/2;
        float right1 = this.position.x + this.width/2;
        float top1 = this.position.y - this.height/2;
        float bot1 = this.position.y + this.height/2;

        float left2 = other.position.x - other.width/2;
        float right2 = other.position.x + other.width/2;
        float top2 = other.position.y - other.height/2;
        float bot2 = other.position.y + other.height/2;

        if (left1 <= right2 && right1 >= left2 && top1 <= bot2 && bot1 >= top2){
            return true;
        } else {
            return false;
        }
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
