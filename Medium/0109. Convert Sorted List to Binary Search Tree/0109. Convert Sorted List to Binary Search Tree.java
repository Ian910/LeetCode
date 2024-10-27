/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    ListNode curr;

    public TreeNode sortedListToBST(ListNode head) {
        int ct = 0;
        curr = head;
        while (head != null) {
            ct++;
            head = head.next;
        }
        return buildTree(0, ct - 1);
    }

    public TreeNode buildTree(int beg, int end) {
        if (beg > end)
            return null;
        int mid = (beg + end) >> 1;
        TreeNode root = new TreeNode();
        root.left = buildTree(beg, mid - 1);
        root.val = curr.val;
        curr = curr.next;
        root.right = buildTree(mid + 1, end);
        return root;
    }
}
