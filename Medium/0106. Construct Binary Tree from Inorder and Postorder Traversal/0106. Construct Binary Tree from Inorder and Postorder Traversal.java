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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return backtracking1(postorder, inorder, 0, postorder.length - 1, 0, postorder.length - 1);
    }


    public TreeNode backtracking1(int[] postorder, int[] inorder, int io_start, int io_end, int po_start, int po_end) {
        if (io_start > io_end || po_start > po_end) return null;
        TreeNode node = new TreeNode(postorder[po_end]);
        int in_i = 0;
        for (; in_i < postorder.length - 1; in_i++)
            if (inorder[in_i] == node.val) break;

        node.left = backtracking1(postorder, inorder, io_start, in_i - 1, po_start, po_start + in_i - io_start - 1);
        node.right = backtracking1(postorder, inorder, in_i + 1, io_end, po_start + in_i - io_start, po_end - 1);

        return node;
    }
}