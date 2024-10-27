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
    public ListNode doubleIt(ListNode head) {
        ListNode cal = new ListNode(0), ans = cal;

        if (head.val >= 5) {
            ListNode temp = new ListNode(1);
            cal.next = temp;
            cal = cal.next;
        }

        while (head != null) {
            int value = head.val * 2 % 10;
            if (head.next != null) value += (head.next.val * 2 / 10);

            ListNode temp = new ListNode(value);
            cal.next = temp;
            cal = cal.next;
            head = head.next;
        }

        return ans.next;
    }
}