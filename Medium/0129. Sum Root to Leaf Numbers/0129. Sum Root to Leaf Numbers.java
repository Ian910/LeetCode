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
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return process(root, 0, 0);
    }

    public int process(TreeNode root, int rootVal, int sum) {
        root.val += rootVal * 10;
        if (root.left == root.right && root.left == null) return sum + root.val;
       if (root.left != null) sum = process(root.left, root.val, sum);
        if (root.right != null) sum = process(root.right, root.val, sum);
        return sum;
    }
}