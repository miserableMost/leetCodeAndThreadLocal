package DataStructures.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
       //测试一把
        System.out.println("测试数组模拟环形队列的方法");
        //创建一个队列
        CircleArray queue = new CircleArray(3);
        char key =  ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while(loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):推出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key){
                case 's':
                    queue.showQueue();;
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.println("取出的数据为："+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //查看队列头
                    try{
                        int res = queue.headQueue();
                        System.out.println("队列头的数据是："+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':   //退出
                    scanner.close();
                    loop = false;
                    break;
            }
            System.out.println("程序退出");
        }
    }
}

class CircleArray{
    private int maxSize;  //表示数组的最大容量
    private int front;  //队列头
    private int rear;  //队列最后一个数据的后一个位置
    private int[] arr;   //该数组用于存储数组，模拟队列
    public CircleArray(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }
    //判断队列是否满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }
    //添加数据到队列
    public void addQueue(int n){
        //判断队列是否满
        if(isFull()){
            System.out.println("队列满，不能加入数据");
            return;
        }
      //直接将数据加入
        arr[rear] = n;
        //将rear后移
        rear = (rear + 1) % maxSize;
    }
    //获取队列的数据，出队列
    public int getQueue(){
        //判断队列是否空
        if(isEmpty()){
            //通过抛出异常
            throw new RuntimeException("队列空，不能取数据");
        }
        //需要分析出front是指向队列的第一个元素
        //1.先把front对应的值保留到一个临时变量

        //2.将front后移

        //3.将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return arr[front];
    }
    //显示队列的所有数据
    public void showQueue(){
        //遍历
        if(isEmpty()){
            System.out.println("队列空的，没有数据");
            return;
        }
        //思路：从front遍历，遍历多少个元素
        //动脑筋
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n",i % maxSize,arr[i % maxSize]);
        }
    }
    //求出当前队列有效数据的个数
    public int size(){
        return (rear + maxSize - front) % maxSize;
    }
    //显示队列的头数据，注意不是取数据
    public int headQueue(){
        //判断
        if(isEmpty()){
            throw new RuntimeException("队列空的，没有头数据");
        }
        return arr[front];
    }
}
