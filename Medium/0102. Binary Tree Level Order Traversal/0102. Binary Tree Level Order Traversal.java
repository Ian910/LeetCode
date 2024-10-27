import java.util.*;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        return new AbstractList<List<Integer>>() {

            List<List<Integer>> ans = new ArrayList<>();
            int size = 0;

            @Override
            public int size() {
                if (ans.isEmpty()) init();
                return ans.size();
            }

            @Override
            public List<Integer> get(int index) {
                if (ans.isEmpty()) init();
                return ans.get(index);
            }

            public void init() {
                inorderBST(root, 0);


            }

            public void inorderBST(TreeNode root, int level) {
                if (root != null) {
                    if (size < level + 1) {
                        ans.add(new ArrayList<>());
                        size = ans.size();
                    }
                    ans.get(level).add(root.val);

                    inorderBST(root.left, level + 1);
                    inorderBST(root.right, level + 1);
                }
            }
        };
    }
}
