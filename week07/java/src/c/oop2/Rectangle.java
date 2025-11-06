package c.oop2;

public class Rectangle {

    int width;
    int height;

    public Rectangle() {
        this(1, 1);
    }

    public Rectangle(int size) {
        this(size, size);
    }

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
