package Test.July;

/**
 * leetCode 234 请判断一个链表是否为回文链表。
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true

 */
public class Test234_isPalindrome {

    public static void main(String[] args) {

    }


    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode mid =  findMid(head);
        mid = reverse(mid);
        while(mid != null){
            if(mid.val != head.val)
                return false;
            mid = mid.next;
            head = head.next;
        }
        return true;

    }
  /*  //将后面一段链表反转
    public static ListNode reverse(ListNode head){
        if(head == null){
            return null;
        }
        //创建一个临时节点
        ListNode tmp = head;
        ListNode next = null;
        //创建一个新链表
        ListNode resultHead = new ListNode(0);
        //还没到最后一个
        while(tmp != null){
            //记住一定要保存原链表的下一个节点，以免丢失
            next = tmp.next;
            //添加进来
            tmp.next = resultHead.next;
            resultHead.next = tmp;
            tmp = next;
        }
        head = resultHead.next;
        return head;
    }*/

    // 翻转链表（迭代、递归）
    //反转
    public static ListNode reverse(ListNode head){
        //假定一个原始辅助节点,表示最前面的节点，初始为空
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            //先保存原节点下一个值
            ListNode temp = cur.next;
            //当前节点加载原节点的前面
            cur.next = pre;
            //这时最前面的节点变成当前加入的节点
            pre = cur;
            //向后移动
            cur = temp;

        }
        return pre;
    }




    //找到中间的节点--快慢指针
    public static ListNode findMid(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
