package findJob.second.gcroots;

/**
 * @author 李聪
 * @date 2020/1/25 13:34
 */
public class StrongReferenceDemo {
    public static void main(String[] args) {
        Object obj1 = new Object();//这样定义的默认就是强引用
        Object obj2 = obj1;   //obj2引用赋值
        obj1 = null;     //置空
        System.gc();
        System.out.println(obj2);
    }
}
