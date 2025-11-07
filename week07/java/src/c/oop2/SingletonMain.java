package c.oop2;

public class SingletonMain {

    public static void main(String[] args) {
        // private 생성자 사용 불가함
        // Singleton singleton = new Singleton();

        // static 메서드로 인스턴스 생성
        // 인스턴스가 생성되어 있으면 생성된 인스턴스 반환 / 인스턴스가 생성되지 않았으면 (null이면) 새로 생성해서 반환
        Singleton singleton = Singleton.getInstance();
    }
}
