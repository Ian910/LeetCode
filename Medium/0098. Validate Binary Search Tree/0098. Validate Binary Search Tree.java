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
    public boolean isValidBST(TreeNode root) {
        // inorder tree, last node must be smaller than current
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        if (minVal >= root.val) return false;
        minVal = root.val;
        if (!isValidBST(root.right)) return false;
        return true;
    }
    private long minVal = Long.MIN_VALUE;
}
