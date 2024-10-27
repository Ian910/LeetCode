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
    public List<TreeNode> generateTrees(int n) {
        return assembleTree(1, n);
    }

    private List<TreeNode> assembleTree(int head, int tail) {
        if (head > tail) return Collections.singletonList((TreeNode) null);

        List<TreeNode> ans = new ArrayList<>();
        for (int root = head; root <= tail; root++) 
            for (TreeNode lt : assembleTree(head, root - 1))
                for (TreeNode rt : assembleTree(root + 1, tail)) {
                    TreeNode node = new TreeNode(root, lt, rt);
                    ans.add(node);
                }
        return ans;
    }
}
