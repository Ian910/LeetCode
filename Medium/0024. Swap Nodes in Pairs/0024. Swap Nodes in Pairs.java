/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode first = new ListNode();
        first.next = head.next;
        ListNode prev = first, curr = head;
        while (true) {
            ListNode temp = curr.next.next;
            curr.next.next = curr;
            prev.next = curr.next;
            curr.next = temp;
            if (curr.next == null || curr.next.next == null)
                break;
            prev = curr;
            curr = curr.next;
        }

        return first.next;
    }
}