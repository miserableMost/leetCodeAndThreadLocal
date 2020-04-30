package Test;

public class DeadLock implements Runnable {
     private static Object obj1 = new Object();
     private static Object obj2 = new Object();
     public int flag = 0;
    @Override
    public void run() {
        if(flag == 0) {
            System.out.println("flag: " + flag);
            synchronized (obj1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj2) {
                    System.out.println("flag: " + flag);
                }
            }
        }
        if(flag == 1) {
            System.out.println("flag: " + flag);
            synchronized (obj2) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj1) {
                    System.out.println("flag: " + flag);
                }
            }
        }
    }
}
