package findJob.second.gcroots;

import java.lang.ref.SoftReference;

/**
 * @author 李聪
 * @date 2020/1/25 13:46
 */
public class SoftReferenceDemo {
    /**
     * 内存够用的时候就保留，不够用的就回收
     */
    public static void softRef_Memory_NotEnough() {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;

        try{
            byte[] bytes = new byte[30 * 1024 * 1024];
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println(o1);
            System.out.println(softReference.get());
        }


    }

    /**
     * 内存够用的时候就保留，不够用时就回收
     */
    public static void softRef_Memory_Enough() {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
        System.gc();
        System.out.println(o1);
        System.out.println(softReference.get());
    }

    public static void main(String[] args) {
        //softRef_Memory_Enough();
        softRef_Memory_NotEnough();
    }
}
