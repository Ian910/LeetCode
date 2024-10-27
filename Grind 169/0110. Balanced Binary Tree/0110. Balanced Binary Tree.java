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
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return (getHeight(root) != -1);
    }

    int getHeight(TreeNode root) {
        if (root == null) return 0;
        int leftValue = getHeight(root.left);
        int rightValue = getHeight(root.right);
        if (leftValue == -1 || rightValue == -1 || Math.abs(leftValue - rightValue) > 1) return -1;
        return Math.max(leftValue, rightValue) + 1;
    }
}