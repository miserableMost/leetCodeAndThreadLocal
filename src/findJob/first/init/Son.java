package findJob.first.init;

/**
 * 先初始化父类 （5）（1）
 * 初始化子类   （10）（6）
 *
 * 子类的实例化方法：
 *  * 1.super() 最前    （9）（3）（2）
 *  * 2.i = test();     （9）
 *  * 3.子类的非静态代码块   （8）
 *  * 4.子类的无参构造 最后  （7）
 *
 *  因为创建两个Son对象，因此实例化<init>执行两次
 *  （9）（3）（2）（9）（8）（7）
 */
//实例初始化就是执行<init>方法
//<init>（）方法可能重载有多个，有几个构造器就有几个<init>方法
//<init>()方法由非静态实例变量显示赋值代码和非静态代码块、对应构造器代码组成
//非静态实例变量显示赋值代码和非静态代码块代码从上到下顺序执行，而对应构造器代码最后执行
//每次创建实例对象，调用对应构造器，执行的就是对应的<init>方法
//<init>方法的首行是super()或super(参数列表),即对应父类的<init>方法
public class Son extends Father{
    private int i = test();
    private static int j = method();
    static{
        System.out.print("(6)");
    }
    Son() {
        //super();           //在子类构造器中一定会调用父类的构造器
        System.out.print("(7)");
    }
    {
        System.out.print("(8)");
    }

    @Override
    public int test() {
        System.out.print("(9)");
        return 1;
    }
    public static int method() {
        System.out.print("(10)");
        return 1;
    }

    public static void main(String[] args) {
        Son s1 = new Son();
        System.out.println();
        Son s2 = new Son();
    }
}
