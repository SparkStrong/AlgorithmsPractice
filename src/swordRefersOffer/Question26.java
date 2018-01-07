package swordRefersOffer;

/**
 * Created by Nack on 2017/12/25.
 */
public class Question26 {
    class ComplexListNode {
        int value;
        ComplexListNode next;
        ComplexListNode sibling;

        ComplexListNode(int value) {
            this.value = value;
        }
    }

    private void cloneNodes(ComplexListNode head) {
        if (head == null) {
            return;
        }

        ComplexListNode cur = head;
        while (cur != null) {
            ComplexListNode nodeClone = new ComplexListNode(cur.value);
            nodeClone.next = cur.next;
            nodeClone.sibling = null;

            cur.next = nodeClone;
            cur = nodeClone.next;
        }
    }

    private void connectSiblingNodes(ComplexListNode head) {
        ComplexListNode cur = head;
        while (cur != null) {
            ComplexListNode nodeClone = cur.next;
            if (cur.sibling != null) {
                nodeClone.sibling = cur.sibling.next;
            }
            cur = nodeClone.next;
        }
    }

    private ComplexListNode connectClonedList(ComplexListNode head) {
        ComplexListNode cloneHead = null;
        ComplexListNode cur = head;
        ComplexListNode cloneCur = null;

        if (cur != null) { // 设置复制链表的头结点
            cloneHead = cur.next;
            cloneCur = cloneHead;
            cur.next = cloneHead.next;
            cur = cloneHead.next;
        }

        while (cur != null) {
            cloneCur.next = cur.next;
            cloneCur = cloneCur.next;
            cur.next = cloneCur.next;
            cur = cur.next;
        }

        return cloneHead;
    }

    public void printList(ComplexListNode head) {
        while (head != null) {
            System.out.print(head.value + "-->");
            ComplexListNode next = head.next;
            if (next != null) {
                System.out.print("next = " + next.value);
            } else {
                System.out.print("next = null; ");
            }
            ComplexListNode sibling = head.sibling;
            if (sibling != null) {
                System.out.print(" sibling = " + sibling.value);
            } else {
                System.out.print(" sibling = null; ");
            }
            head = head.next;
            System.out.println();
        }
        System.out.println();
    }

    public ComplexListNode clone(ComplexListNode head) {
        cloneNodes(head);
        connectSiblingNodes(head);
        return connectClonedList(head);
    }

    public void test1() {
        ComplexListNode head = new ComplexListNode(1);
        head.sibling = head;
        head.next = null;
        ComplexListNode result = clone(head);
        printList(result);
    }

    public void test2() {
        ComplexListNode head = new ComplexListNode(1);
        ComplexListNode node2 = new ComplexListNode(2);
        head.next = node2;
        node2.sibling = head;
        head.sibling = node2;

        ComplexListNode result = clone(head);
        printList(result);
    }

    public void test3() {
        ComplexListNode head = new ComplexListNode(1);
        ComplexListNode node2 = new ComplexListNode(2);
        head.next = node2;
        head.sibling = node2;
        node2.next = null;
        node2.sibling = null;

        ComplexListNode result = clone(head);
        printList(result);
    }
}
