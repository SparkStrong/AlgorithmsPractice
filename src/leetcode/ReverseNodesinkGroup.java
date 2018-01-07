package leetcode;

/**
 * Created by Nack on 2017/10/23.
 */
public class ReverseNodesinkGroup {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummpy = new ListNode(0);
        dummpy.next = head;
        ListNode preTail = dummpy;
        ListNode cur = head, nextHead = head;

        while (cur != null) {
            ListNode curHead = nextHead;  // 将新一轮次的头节点指向上一次的下一头节点

            // 将当前节点尝试向后移动k个节点
            int i = 1;
            ListNode pre = cur;
            for (; cur != null && i <= k; i++) {
                pre = cur;
                cur = cur.next;
            }

            // 剩余的节点数不足k,不需要翻卷直接返回
            if (i < k) {
                return dummpy.next;
            }

            nextHead = cur; // cur在向后移动k个节点后，已经指向了下一轮次的头结点
            ListNode reversedHead = reverseBetweenNodes(curHead, nextHead);
            preTail.next = reversedHead; // 将上一轮次的尾节点指向翻卷过后的该轮次的头节点
            preTail = pre; // 更新尾节点
        }

        return dummpy.next;
    }

    public ListNode reverseBetweenNodes(ListNode head, ListNode nextHead) {
        ListNode cur = head.next;
        head.next = nextHead;

        while (cur != nextHead) {
            ListNode tmp = cur.next;
            cur.next = head;
            head = cur;
            cur = tmp;
        }

        return head;
    }
}
