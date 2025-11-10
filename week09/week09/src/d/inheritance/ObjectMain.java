package d.inheritance;

class MyObject {

    String name;
    int age;

    public MyObject(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyObject{" +
            "name='" + name + '\'' +
            ", age=" + age +
            '}';
    }
}

public class ObjectMain {

    public static void main(String[] args) {
        MyObject obj = new MyObject("test", 100);
        System.out.println(obj.toString());
    }
}
