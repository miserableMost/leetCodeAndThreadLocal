package Test.August;

public class Error {
    public static void main(String[] args) {
        String s = new StringBuilder("计算机").append("软件").toString();
        System.out.println(s.intern() == s);

        String s1 = new StringBuilder("ja").append("va").toString();
        System.out.println(s1.intern() == s1);
    }
}
