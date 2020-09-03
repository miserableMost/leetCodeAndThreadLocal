package testAgin;

/**
 * @author 李聪
 * @date 2020/8/7 15:21
 */
class ListNode {
    int key;
    ListNode next;
    public ListNode(int key){
        this.key = key;
    }
}
public class Singleton {
    public static void main(String[] args) {
        new ListNode(1);
    }
    public static volatile Singleton singleton;
    public Singleton(){

    }
    public Singleton getSingleton() {
        if(singleton == null) {
            synchronized (Singleton.class) {
                if(singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
