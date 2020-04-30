package Test.April;

/**leetCode: 754. 到达终点数字
 * 在一根无限长的数轴上，你站在0的位置。终点在target的位置。
 *
 * 每次你可以选择向左或向右移动。第 n 次移动（从 1 开始），可以走 n 步。
 *
 * 返回到达终点需要的最小移动次数。
 * 输入: target = 3
 * 输出: 2
 * 解释:
 * 第一次移动，从 0 到 1 。
 * 第二次移动，从 1 到 3 。
 */
public class Test754_reachNumber {

    public static void main(String[] args) {
        System.out.println(reachNumber(3));
    }

    public static int reachNumber(int target) {
        //target无论正负左右对称 target = a-b+c;-target = -a+b-c
          int end = Math.abs(target);
          int sum = 0 ;
          int i = 0;
          //规定向右，越向右前进次数越少，假定每次都向右前进
          //只要sum超出end的部分为偶数，就立马得行只需将前面加的n变号，相当于-2n
          while(sum < end || (sum-end)%2 != 0){

                  i++;
                  sum = sum + i;
          }
     /*     while(sum < end){
              i++;
              sum += i;
          }
          int result = sum -end;
          if(result%2 == 0){
              return i;
          }else {
              if(i%2 == 0){
                  //超出部分已为奇数，证明立马会加上i+1，i为偶数，则i+1为奇数 奇数+奇数为偶数
                  return i+1;
              }else{
                  //超出部分已为奇数，证明立马会加上i+1，i为奇数数，则i+1为偶数，
                  return i+2;
              }
          }*/


          return i  ;
     }
}
