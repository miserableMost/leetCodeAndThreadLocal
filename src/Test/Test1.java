package Test;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test1 {
    public static void main(String[] args) {
       /* List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
      *//*  Collections.sort(names,(a,b) -> b.compareTo(a));
        for (String name : names) {
            System.out.print(name + " ");
        }*//*
        names.stream().filter((s)->s.startsWith("a")).forEach(System.out::println);
      *//*  Converter<String, Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("123");
        System.out.println(converted.getClass());*//*
        String concat = Stream.of("a", "B", "c", "D", "e", "F").
                filter(x -> x.compareTo("Z") > 0).
                reduce("", String::concat);
        System.out.println(concat);*/
        /*int[] nums = {1,2,3,4,5};
        for (int i = 0; i < nums.length;++i) {
            System.out.print(nums[i] + " ");
        }*/
       /* MyThread thread = new MyThread();
        thread.start();*/
       //创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //通过线程池创建线程
        executorService.execute(new MyRunnable());

    }
}


class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("myThread正在执行"+new Date().getTime());
        }
    }
}
class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("myRunnable正在执行"+new Date().getTime());
        }
    }
}