package leetcode;

/**
 * Created by Nack on 2017/7/12.
 */



import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BottomLeftTreeValue {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int findBottomLeftValue(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Stack<TreeNode> stack;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        TreeNode result = null;
        while (!queue.isEmpty()) {
            result = queue.remove();
            if(result.right != null) {
                queue.add(result.right);
            }
            if(result.left != null) {
                queue.add(result.left);
            }
        }

        return result.val;
    }
}
