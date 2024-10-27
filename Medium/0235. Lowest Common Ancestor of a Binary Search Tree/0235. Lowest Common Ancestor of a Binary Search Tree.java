
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int rootValue = root.val;
        if (p.val < rootValue && q.val < rootValue) return lowestCommonAncestor(root.left, p, q);
        if (p.val > rootValue && q.val > rootValue) return lowestCommonAncestor(root.right, p, q);
        return new TreeNode(rootValue);
    }
}