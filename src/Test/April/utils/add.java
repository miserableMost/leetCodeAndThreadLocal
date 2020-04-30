package Test.April.utils;

/**
 * @author 李聪
 * @date 2020/1/5 15:20
 */
class A {

    static {
        System.out.print("1");
    }

    public A() {
        System.out.print("2");
    }
}

class B extends A {

    static {
        System.out.print("a");
    }

    public B() {
        System.out.print("b");
    }
}

public class add {

    public static void main(String[] args) {
        A ab = new B();
        ab = new B();
    }
}

