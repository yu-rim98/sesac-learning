package e.generic;

class Parent<T> {
    private T value;

    public Parent(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

class Child<T> extends Parent<T> {

    public Child(T value) {
        super(value);
    }
}

// 상속 시 제네릭을 String으로 강제함
class StringChild<String> extends Parent<String> {

    public StringChild(String value) {
        super(value);
    }
}

// 제네릭 확장
class ExtendsChild<T, U> extends Parent<T> {

    private U value2;

    public ExtendsChild(T value, U value2) {
        super(value);
        this.value2 = value2;
    }
}

public class Inheritance {

    public static void main(String[] args) {
        Parent<String> p1 = new Parent<>("hello");
        Child<String> c1 = new Child<>("hi");

        StringChild sc1 = new StringChild("hihi");
        ExtendsChild<String, Integer> ec1 = new ExtendsChild<>("kim", 20);
    }

}
