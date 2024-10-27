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
    public int findBottomLeftValue(TreeNode root) {
        countProcess(root, 1);
        return ans[1];
    }

    public void countProcess(TreeNode root, int times) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (times > ans[0]) {
                ans[0] = times;
                ans[1] = root.val;
            }
            return;
        }
        countProcess(root.left, times + 1);
        countProcess(root.right, times + 1);
    }

    int[] ans = new int[2];
}