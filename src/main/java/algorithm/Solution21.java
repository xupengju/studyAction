package algorithm;

/**
 * @author Milo on 2021/12/22.
 * @description 21. 合并两个有序链表
 */
public class Solution21 {


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1), current = dummy;

        while (l1 != null && l2 != null) {


            if (l1.val > l2.val) {
                current.next = l2;
                l2 = l2.next;
            }else{
                current.next = l1;
                l1 = l1.next;
            }

            current = current.next;

        }

        if (l1 == null) {
            current.next = l2;
        }

        if (l2 == null) {
            current.next = l1;
        }

        return dummy.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode res = l1.val < l2.val ? l1 : l2;
        res.next = mergeTwoLists2(res.next, l1.val < l2.val ? l2 : l1);
        return res;
    }

    public static void main(String[] args) {
        ListNode listNode = mergeTwoLists(new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(6)))), new ListNode(2, new ListNode(4, new ListNode(8, new ListNode(9)))));

        System.out.println(listNode);


    }
}
