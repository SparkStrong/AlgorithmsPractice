package leetcode;

/**
 * Created by Nack on 2017/10/23.
 */
public class SwapNodesinPairs {
    class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    public ListNode swapPairs(ListNode head) {
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode cur = first;

        while (cur.next != null && cur.next.next != null) {
            ListNode tmp = cur.next;
            ListNode tmp2 = cur.next.next;
            tmp.next = tmp2.next;
            cur.next = tmp2;
            tmp2.next = tmp;
            cur = cur.next.next;
        }

        return first.next;
    }

    public static void main(String[] args) {

    }
}
