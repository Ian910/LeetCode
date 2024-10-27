
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
import java.util.*;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        return new AbstractList<List<Integer>>() {

            List<List<Integer>> ans = null;

            @Override
            public List<Integer> get(int index) {
                if (ans == null)
                    init();
                return ans.get(index);
            }

            @Override
            public int size() {
                if (ans == null)
                    init();
                return ans.size();
            }

            public void init() {
                ans = new ArrayList<>();
                if (root != null)
                    backtracking(root, new ArrayList<>(), 0);
            }

            public void backtracking(TreeNode tree, List<Integer> list, int sum) {
                sum += tree.val;
                list.add(tree.val);
                if (sum == targetSum && tree.left == null && tree.right == null) {
                    ans.add(new ArrayList<>(list));
                    return;
                }

                if (tree.left != null) {
                    backtracking(tree.left, list, sum);
                    list.remove(list.size() - 1);
                }
                if (tree.right != null) {
                    backtracking(tree.right, list, sum);
                    list.remove(list.size() - 1);
                }
            }
        };
    }
}
