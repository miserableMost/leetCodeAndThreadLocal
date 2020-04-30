package Test;

public class WaitNotifyRunnable {
    private Object obj = new Object();
    private Integer i=0;
    public void odd() {
        while(i<10){
            synchronized (obj){
                if(i%2 == 1){
                    System.out.println("奇数："+i);
                    i++;
                    obj.notify();
                } else {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void even(){
        while(i<10){
            synchronized (obj){
                if(i%2 == 0){
                    System.out.println("偶数："+i);
                    i++;
                    obj.notify();
                } else {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public static void main(String[] args){
        final WaitNotifyRunnable runnable = new WaitNotifyRunnable();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                runnable.odd();
            }
        }, "偶数线程");
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                runnable.even();
            }
        }, "奇数线程");

        t1.start();
        t2.start();
    }
}
