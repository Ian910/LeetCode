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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return subRoot == null;
        return isSametree(root, subRoot) || isSubtree(root.left, subRoot.left) || isSubtree(root.right, subRoot.right);
    }

    private boolean isSametree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) return root == null && subRoot == null;
        return root.val != subRoot.val ? false : isSametree(root.left, subRoot.left) && isSametree(root.right, subRoot.right);
    }
}