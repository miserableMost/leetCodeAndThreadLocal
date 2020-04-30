package findJob.first.test;

import findJob.first.singleton.Singleton3;

public class TestSinleton3 {
    public static void main(String[] args) {
        Singleton3 s = Singleton3.INSTANCE;
        System.out.println(s);
    }
}
