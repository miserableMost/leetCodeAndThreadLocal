package findJob.second.gcroots;

import java.lang.ref.WeakReference;

/**
 * @author 李聪
 * @date 2020/1/25 14:02
 */
public class WeakReferenceDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o1);
        System.out.println(o1);
        System.out.println(weakReference.get());
        o1 = null;
        System.gc();

        System.out.println(o1);
        System.out.println(weakReference.get());
        //Map<String, SoftReference<BitMap>> imageCache = new HashMap<String,SoftReference<BitMap>>();
    }
}
