package Test.July;

public class Test2 {
    public static void main(String[] args) {

      /*  MyThread m1 = new MyThread();
        MyThread m2 = new MyThread();
        MyThread m3 = new MyThread();
        MyThread m4 = new MyThread();
        m1.setName("圣诞节");
        m2.setName("阿哥");
        m3.setName("大课间");
        m1.start();
        m2.start();
        m3.start();*/
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println(getName()+i);
            //礼让
            Thread.yield();
        }
    }
}
