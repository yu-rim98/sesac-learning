package e.generic;

class Box2<T> {
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}

public class WithGeneric {

    public static void main(String[] args) {
        Box2<String> box2 = new Box2<>();
        Box2<Integer> integerBox2 = new Box2<>();

        box2.setItem("hello");
        String str = box2.getItem();

        integerBox2.setItem(123);
        int i = integerBox2.getItem();


    }
}
