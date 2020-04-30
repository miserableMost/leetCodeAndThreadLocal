package sort;

/**
 * @author 李聪
 * @date 2020/4/21 22:53
 */
public class GenericClass<T> {
    private T data;

    public T getData() {
        return data;
    }
    private  <T> T genericAdd(T a, T b) {
        System.out.println(a + "+" + b + "="+a+b);
        return a;
    }
    public <T> void show02(T t) {
        System.out.println(t.toString());
    }

    public <K> void show03(K k) {
        System.out.println(k.toString());
    }
    public void setData(T data) {
        this.data = data;
    }

    public static void main(String[] args) {
        GenericClass<String> genericClass=new GenericClass<>();
        genericClass.setData("Generic Class");
        System.out.println(genericClass.getData());
    }
}
