/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void recoverTree(TreeNode root) {
        inorderBST(root);
        if (fault1 != null && fault2 != null) fault1.val =fault1.val = (fault1.val + fault2.val) - (fault2.val = fault1.val);
    }

    public void inorderBST(TreeNode root) {
        // inorder tree, last node must be smaller than current
        if (root == null) return;
        inorderBST(root.left);
        if (minVal >= root.val) {
            if (fault1 == null) fault1 = pre;
            fault2 = root;
        }
        pre = root;
        minVal = root.val;
        inorderBST(root.right);
    }

    private long minVal = Long.MIN_VALUE;
    private TreeNode pre, fault1 = null, fault2 = null;
}
