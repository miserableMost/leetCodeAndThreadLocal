package findJob.second.JUC;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 集合类不安全的问题
 * ArrayList
 * @author 李聪
 * @date 2020/1/16 20:27
 */
public class ContainerNotSafeDemo {
    public static void main(String[] args) {
        /*List<String> list = Arrays.asList("a","b","c");
        list.forEach(System.out::println);*/
        Map<String,String> map = new ConcurrentHashMap<>();  //Collections.synchronizedSortedMap();
        for(int i = 1;i <= 30;i ++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }

    private static void setNotSafe() {
        Set<String> set = new CopyOnWriteArraySet<>();                        // Collections.synchronizedSet(new HashSet<>());
        for(int i = 1;i <= 30;i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
        new HashSet<>().add("a");//hashset底层就是hashMap
    }

    private static void listNotSafe() {
        List<String> list = new CopyOnWriteArrayList<>();

        for(int i = 1;i <= 30;i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
        //并发修改异常
        // java.util.ConcurrentModificationException

        /**
         * 不要只是会用，会用只不过是API调用工程师
         * 底层原理？
         * 1.故障现象
         *  java.util.ConcurrentModificationException
         *  2.导致原因
         *      并发争抢修改导致，参考我们的花名册签名情况。
         *      一个人正在写入，另外一个同学过来抢夺，导致数据不一致异常。并发修改异常。
         *  3.解决方案
         *      3.1 vector
         *      3.2 Collections.synchronizedList
         *      3.3 CopyOnWriteArrayList
         *  4.优化建议（同样的错误不犯第二次）
         */
    }
}
