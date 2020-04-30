package Test.April.utils;

/**
 * @author 李聪
 * @date 2020/1/5 16:30
 */
public class TestOk {
    private TestOk(){}
    public int age(){
        return 1;
    }
    public static void main(String[] args) {
        TestOk t = new TestOk();
        System.out.println(t.age());

        System.out.println("asad");
    }
}
