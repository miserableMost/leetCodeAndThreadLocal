package findJob.first.test;

import findJob.first.singleton.Singleton1;

public class TestSingleton1 {
    public static void main(String[] args) {
        Singleton1 s1 = Singleton1.INSTANCE;
        System.out.println(s1);
    }
}
