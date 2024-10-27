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
class Solution {
    public ListNode reverseList(ListNode head) {
        return process(head, null);
    }

    private ListNode process(ListNode head, ListNode ans) {
        if (head == null) return ans;
        ListNode temp = new ListNode(head.val);
        temp.next = ans;
        ans = temp;
        return process(head.next, ans);
    }
}