package c.oop2;

public class Person {

    String name;
    int age;
    String address;

    // 기본 생성자 → 다른 생성자 호출
    public Person() {
        this("이름 없음", 0, "주소 없음");
    }

    // 이름만 → 다른 생성자 호출
    public Person(String name) {
        this(name, 0, "주소 없음");
    }

    // 이름과 나이 → 다른 생성자 호출
    public Person(String name, int age) {
        this(name, age, "주소 없음");
    }

    // 모든 필드 → 실제 초기화 수행
    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}
