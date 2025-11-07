package c.oop2;

public class Enum {

    public static void main(String[] args) {
        Direction direction = Direction.NORTH;
        System.out.println(direction);

        System.out.println(direction.name());

        // enum의 순서 반환
        System.out.println(direction.ordinal());


    }

}
