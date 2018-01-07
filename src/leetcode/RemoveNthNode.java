package leetcode;

/**
 * Created by Nack on 2017/10/16.
 */
public class RemoveNthNode {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head, second = head;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        boolean flag = false;
        if (first != null) {
            while (first.next != null) {
                flag = true;
                first = first.next;
                second = second.next;
            }
        }

        if (flag) {
            ListNode tmp = second.next;
            second.next = tmp.next;
            tmp = null;
        } else {
            ListNode tmp = head;
            head = head.next;
            tmp = null;
        }

        return head;
    }
}
