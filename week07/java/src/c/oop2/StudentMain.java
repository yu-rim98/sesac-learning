package c.oop2;

public class StudentMain {

    public static void main(String[] args) {
        Student s1 = new Student("kim", 100);
        Student s2 = new Student("lee", 90);

        System.out.println(s1.getName());
        System.out.println(Student.getTotalStudent());
        System.out.println(Student.getAverageScore());

        Student s3 = new Student("choi", 80);
        System.out.println(Student.getAverageScore());

    }

}
