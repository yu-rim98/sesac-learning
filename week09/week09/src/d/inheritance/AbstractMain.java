package d.inheritance;

abstract class Animal4 {
    String name;

    public Animal4(String name) {
        this.name = name;
    }
}
public class AbstractMain {

    public static void main(String[] args) {
        Animal4 a = new Animal4("동물");
    }

}
