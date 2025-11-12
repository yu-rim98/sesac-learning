package e.generic;

class Container<T> {
    private T value;

    public Container(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

public class SingleType {

    public static void main(String[] args) {
        Container<String> c1 = new Container<>("hello");
        System.out.println(c1.getValue());
    }

}


