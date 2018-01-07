package leetcode.sixtyTo80;

/**
 * Created by Nack on 2017/12/21.
 */
public class RotateList61 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        int listLength = 0;

        ListNode cur = head, pre = cur, tail = cur;
        while (cur != null) {
            listLength ++;
            tail = cur;
            cur = cur.next;
        }
        cur = head;

        k = k % listLength;
        if (k == 0) {
            return head;
        }

        for (int i = 0; i < listLength - k; i++) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = null;
        tail.next = head;
        head = cur;

        return head;
    }
}
