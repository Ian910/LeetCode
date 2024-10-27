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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = new ListNode(-101), ans;
        current.next = head;
        ans = current;
        while (current.next != null && current.next.next != null) {
            if (current.next.val == current.next.next.val) {
                while (current.next.next != null && current.next.val == current.next.next.val) {
                    current.next = current.next.next;
                }
                if (current.next.next != null) current.next = current.next.next;
                else current.next = null;
            } else {
                current = current.next;
            }
        }

        return ans.next;
    }
}