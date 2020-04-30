package medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * leetCode 735 : 行星碰撞
 * 给定一个整数数组 asteroids，表示在同一行的行星。
 *
 * 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
 *
 * 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞
 *
 */
public class T735_asteroidCollision_8_18 {
    public static void main(String[] args) {
        int[] a = {-2,2,1,-2};
        int[] init = asteroidCollision(a);
        System.out.println(Arrays.toString(init));
    }
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        boolean flag = false;
        for (int i = 0; i < asteroids.length; i++) {
            //若前面的为负数，直接添加
            if(asteroids[i] < 0 && flag == false){
                stack.push(asteroids[i]);
            //出现正数了
            }else if(asteroids[i] > 0){
                flag = true;
                stack.push(asteroids[i]);
            //出现正数以后的负数
            }else if(asteroids[i] < 0){
                    //当栈顶元素为正且绝对值小于此负数时，弹出栈顶
                    while(stack.size() > 0 && stack.peek() > 0 && stack.peek() <  Math.abs(asteroids[i])){

                            stack.pop();

                    }
                    //栈顶元素大于0且与此负数绝对值相等时，弹出栈顶元素
                    if(stack.size() > 0 && stack.peek() > 0 && stack.peek() == Math.abs(asteroids[i])){
                        stack.pop();
                    }
                    //只有栈顶为负数或者为空时当前负数才加入
                    else if((stack.size() > 0 && stack.peek() < 0) || stack.size() == 0){
                        stack.push(asteroids[i]);
                    }


                }


        }

        int[] res = new int[stack.size()];
        if(stack.size() == 0)
            return res;
        for (int i = stack.size() - 1; i >= 0 ; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
