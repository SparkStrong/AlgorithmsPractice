package leetcode;

/**
 * Created by Nack on 2017/9/24.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeTwoSortedLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode root = null, cur = null;
        if (l1.val < l2.val) {
            root = new ListNode(l1.val);
            l1 = l1.next;
        } else {
            root = new ListNode(l2.val);
            l2 = l2.next;
        }
        cur = root;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = new ListNode(l1.val);
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = new ListNode(l2.val);
                cur = cur.next;
                l2 = l2.next;
            }
        }

        while (l1 != null) {
            cur.next = new ListNode(l1.val);
            cur = cur.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            cur.next = new ListNode(l2.val);
            cur = cur.next;
            l2 = l2.next;
        }

        return root;
    }
}
