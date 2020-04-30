package PSoffer;

/**
 * @author 李聪
 * @date 2019/12/20 20:45
 */
public class T15 {
    public static void main(String[] args) {

    }
    public ListNode Merge(ListNode list1, ListNode list2) {
        //创建一个链表
        ListNode dumy = new ListNode(-1);
        ListNode temp = dumy;   //创建它的指针
        while(list1 != null && list2 != null) {




            if(list1.val <= list2.val) {
                temp.next = list1;
                temp = temp.next;
                list1 = list1.next;
            }else {
                temp.next = list2;
                temp = temp.next;
                list2 = list2.next;
            }

        }
        while(list1 != null) {
            temp.next = list1;
            temp = temp.next;
            list1 = list1.next;
        }
        while(list2 != null) {
            temp.next = list2;
            temp = temp.next;
            list2 = list2.next;
        }







        return dumy.next;
    }
}
