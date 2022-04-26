package algorithm;

import java.util.PriorityQueue;

/**
 * @author Milo on 2022/4/1.
 * @description 23. 合并K个升序链表
 */
public class Solution23 {


    public ListNode mergeKLists(ListNode[] lists){

        if (lists.length ==0){
            return null;
        }
        ListNode result = new ListNode(-1);

        ListNode p = result;

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>(lists.length,(a,b)-> (a.val-b.val));


        for (ListNode node : lists){
            if (node != null)
                priorityQueue.add(node);
        }

        while (!priorityQueue.isEmpty()){

            ListNode poll = priorityQueue.poll();
            p.next = poll;

            if (poll.next != null) {
                priorityQueue.add(poll.next);
            }
            p = p.next;

        }

        return result.next;
    }

    public static void main(String[] args) {

    }

}
