package findJob.second.JUC;

/**
 * @author 李聪
 * @date 2020/1/7 10:32
 */
public class T1 {
    volatile int n = 0;
    public void add() {
        n ++;
    }

    public static void main(String[] args) {
        T1 t1 = new T1();
        t1.add();
    }
}
