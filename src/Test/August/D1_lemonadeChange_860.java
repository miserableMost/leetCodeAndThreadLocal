package Test.August;

/**
 * leetCode 860:柠檬水找零
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 *
 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 *
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 *
 * 注意，一开始你手头没有任何零钱。
 *
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false
 */
public class D1_lemonadeChange_860 {
    public static void main(String[] args) {
         int[] bills = {5,5,10,10,20};
        boolean b = lemonadeChange(bills);
        System.out.println(b);
    }
    public static boolean lemonadeChange(int[] bills) {
        if(bills.length == 0)
            return true;
        if(bills[0] != 5)
            return false;
          //定义一个map存储
       /* Map<Integer,Integer> map = new HashMap<>();
        map.put(5,1);
        for (int i = 1; i < bills.length; i++) {
            //收到的是5元钱
            if(bills[i] == 5){
                map.put(5,map.get(5) + 1);
            //收到的是10元钱
            }else if(bills[i] == 10){
                if(map.get(5) <= 0)
                    return false;
                map.put(5,map.get(5) - 1);
                map.put(10,map.getOrDefault(10,0) + 1);
            //收到的是20 - 5 == 10 + 5 == 5 + 5 + 5
            }else{
                //如果存储中包含有10
                if (map.containsKey(10) && map.get(10) > 0 && map.get(5) > 0) {
                    map.put(5,map.get(5) - 1);
                    map.put(10,map.get(10) - 1);
                   // map.put(20,map.getOrDefault(20,0) + 1);
                }else if(map.get(5) > 2){
                    map.put(5,map.get(5) - 3);
                   // map.put(20,map.getOrDefault(20,0) + 1);
                }else{
                    return false;
                }
            }
        }*/
        int five = 0,ten = 0;
        for (int bill : bills) {
            if(bill == 5){
                five ++;
            }else if(bill == 10){
                if(five > 0){
                    five --;
                    ten ++;
                }else
                   return false;
            }else{
                if(five > 0 && ten > 0){
                    five --;
                    ten --;
                }else if(five > 2){
                    five -= 3;
                }else
                    return false;
            }
        }
        return true;
    }
}
