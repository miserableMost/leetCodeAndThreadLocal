package Test;

public class DeadLockDemo {
    public static void main(String[] args) {
        DeadLock deadLock1 = new DeadLock();
        DeadLock deadLock2 = new DeadLock();
        deadLock2.flag = 1;

        Thread thread1 = new Thread(deadLock1);
        Thread thread2 = new Thread(deadLock2);

        thread1.start();
        thread2.start();
    }
}
