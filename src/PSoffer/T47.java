package PSoffer;

/**
 * @author 李聪
 * @date 2019/12/29 9:56
 */
public class T47 {
    public static void main(String[] args) {
        int n1 = 5,n2 = 7;
        T47 t47 = new T47();
        int i = t47.Add(n1, n2);
        System.out.println(i);
    }
    public int Add(int num1,int num2) {
        while(num2 != 0) {
            //计算每个位的和
            int temp = num1^num2;
            //计算进位--相与
            num2 = (num1&num2) << 1;
            num1 = temp;
        }
        return num1;
    }
}
