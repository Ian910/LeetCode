/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        countProcess(root);
        return max;
    }

    public int countProcess(TreeNode root) {
        if (root == null) return 0;
        int left = countProcess(root.left), right = countProcess(root.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }

    int max = 0;
}