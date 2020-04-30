package findJob.first.test;

import findJob.first.singleton.Singleton2;

public class TestSingleton2 {
    public static void main(String[] args) {
        Singleton2 s2 = Singleton2.INSTANCE;
        System.out.println(s2);
    }
}
