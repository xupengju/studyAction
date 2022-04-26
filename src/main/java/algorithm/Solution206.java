package algorithm;

/**
 * @author Milo on 2022/4/6.
 * @description 206. 反转链表
 */
public class Solution206 {
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        while(current != null){
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;

        }
        return pre;
    }

    public static void main(String[] args) {
        System.out.println(new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(6)))));
        ListNode node = reverseList(new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(6)))));
        System.out.println(node);
    }

}
