package findJob.second.JUC;

/**
 * @author 李聪
 * @date 2020/1/7 20:19
 */
public class ReSortSeqDemo {
    int a = 0;
    boolean flag = false;

    public void method01() {
        a = 1;          //语句1
        flag = true;    //语句2
    }
    //多线程环境中线程交替执行，由于编译器优化重排的存在，两个线程中使用的变量能否保证一致性是无法确定的，结果无法预测。
    public void method02() {
        if(flag) {
            a = a + 5;
            System.out.println("****retValue: " + a);
        }
    }
}
