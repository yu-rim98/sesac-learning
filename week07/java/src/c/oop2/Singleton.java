package c.oop2;

public class Singleton {
    private static Singleton inst = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (inst == null) {
            return new Singleton();
        }
        return inst;
    }
}
