package tryTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 李聪
 * @date 2020/7/6 23:43
 */
public class LruT {
    public static void main(String[] args) {
        Map<Integer,Student> m = new HashMap<>();
        Student s1 = new Student(1, "12");
        m.put(1,s1);
        for (Map.Entry<Integer, Student> studentEntry : m.entrySet()) {
            System.out.println(studentEntry.getKey() + " : " + studentEntry.getValue());
        }
        s1.setName("2342");
        for (Map.Entry<Integer, Student> studentEntry : m.entrySet()) {
            System.out.println(studentEntry.getKey() + " : " + studentEntry.getValue());
        }
    }
}

class Student {
    private int age;
    private String name;

    public Student() {
    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
