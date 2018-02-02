package util;

public class BinaryTree<T extends Comparable<T>> {
    private final BinaryTreeNode<T> root;  // 二叉树根节点，但是是空节点，参考带头结点的链表
    //node number
    private java.util.concurrent.atomic.AtomicLong size =
            new java.util.concurrent.atomic.AtomicLong(0);

    public BinaryTree() {
        this.root = new BinaryTreeNode<>();
    }

//    public BinaryTree(T value) {
//        this();
//        this.add(value);
//    }

    public BinaryTreeNode<T> getRoot() {
        return this.root.getLeft();
    }

    /**
     * 查找
     * @param value 要查的值
     * @return 存在则返回该值，不存在返回null
     */
    public T find(T value) {
        BinaryTreeNode<T> node = getRoot();
        while (node != null) {
            int cmp = node.getValue().compareTo(value);
            if (cmp < 0) {
                node = node.getRight();
            } else if (cmp > 0) {
                node = node.getLeft();
            } else {
                return node.getValue();
            }
        }

        return null;
    }

    /**
     * 添加元素，添加成功返回null
     * @param value 值
     * @return 正产返回null
     */
    public T add(T value) {
        BinaryTreeNode<T> node = new BinaryTreeNode<>(value);
        return addNode(node);
    }

    /**
     * 插入节点到二叉树中
     * @param node 要插入的节点
     * @return 正常返回null
     */
    private T addNode(BinaryTreeNode<T> node) {
        if (this.root.getLeft() == null) {
            this.root.setLeft(node);
            size.incrementAndGet();
        } else {
            BinaryTreeNode<T> parent = findParent(node);
            int cmp = parent.getValue().compareTo(node.getValue());

            if (cmp > 0) {  // 父节点值大于要插入的节点值
                parent.setLeft(node);
            } else {  // <=
                parent.setRight(node);
            }

            size.incrementAndGet();
        }

        return null;
    }

    /**
     * 查找节点的父节点
     * @param node 要找的节点
     * @return 父节点
     */
    private BinaryTreeNode<T> findParent(BinaryTreeNode<T> node) {
        BinaryTreeNode<T> preNode = getRoot();
        BinaryTreeNode<T> curNode = preNode;

        while (curNode != null) {
            int cmp = curNode.getValue().compareTo(node.getValue());

            if (cmp == 0) {
                return curNode;
            }
            if (cmp < 0) {
                preNode = curNode;
                curNode = curNode.getRight();
            } else {
                preNode = curNode;
                curNode = curNode.getLeft();
            }
        }

        return preNode;
    }

}
