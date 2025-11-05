package b.oop;

public class Intro {

    public static void main(String[] args) {
        int rec1 = calArea(100, 200);
        System.out.println(rec1);

        int rec2 = calArea(10, 20);
        System.out.println(rec2);
    }

    public static int calArea(int width, int height) {
        return width * height;
    }
}
