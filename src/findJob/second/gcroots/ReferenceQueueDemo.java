package findJob.second.gcroots;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author 李聪
 * @date 2020/1/25 14:59
 */
public class ReferenceQueueDemo {
    public static void main(String[] args) throws Exception{
        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        WeakReference<Object> weakReference = new WeakReference<>(o1,referenceQueue);

        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());

        System.out.println("=======");
        o1 = null;
        System.gc();
        Thread.sleep(500);

        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());
    }
}
