package util;

public class BinaryTreeNode<T extends Comparable<T>> {
    private T value;
    private BinaryTreeNode<T> left;  //left child pointer
    private BinaryTreeNode<T> right;  //right child pointer
    private BinaryTreeNode<T> parent;  //parent pointer

    public BinaryTreeNode() {
        this.left = null;
        this.right = null;
    }

    public BinaryTreeNode(T value) {
        this();
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    public BinaryTreeNode<T> getParent() {
        return parent;
    }

    public void setParent(BinaryTreeNode<T> parent) {
        this.parent = parent;
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "value=" + value +
                '}';
    }
}
