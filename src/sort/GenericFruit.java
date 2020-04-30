package sort;

/**
 * @author 李聪
 * @date 2020/4/21 22:40
 */
public class GenericFruit<T>{
    //key这个成员变量的类型为T,T的类型由外部指定
    private T key;

    public GenericFruit(T key) { //泛型构造方法形参key的类型也为T，T的类型由外部指定
        this.key = key;
    }

    public T getKey(){ //泛型方法getKey的返回值类型为T，T的类型由外部指定
        return key;
    }

    public static void main(String[] args) {
        Color green = Color.GREEN;
        System.out.println(green);
    }
}
