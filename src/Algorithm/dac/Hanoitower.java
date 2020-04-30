package Algorithm.dac;

public class Hanoitower {
    public static void main(String[] args) {
        hanoiTower(2,'A','B','C');
    }


    //汉诺塔移动的方法
    //使用分治算法
    public static void hanoiTower(int num,char a,char b,char c){
        //如果只有一个盘
        if(num == 1){
            System.out.println("第一个盘从 "+ a + "->" + c);
        }else{
            //如果我们有n>=2情况，我们总是可以看成是两个盘：1.最下边的一个盘2.上面所有的盘
            //先把上面所有的盘A-B,移动过程中会使用到c
            hanoiTower(num - 1,a,c,b);
            //2.把最下面的盘A-C
            System.out.println("第"+ num +"个盘从 "+ a + "->" + c);
            //3.从B塔的所有盘从B->C,移动过程中使用到a塔
            hanoiTower(num - 1,b,a,c);
        }
    }
}
