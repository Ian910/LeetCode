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
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = l1, lastL1 = l1;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        boolean carry = false;
        int sum = 0;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + (carry == true ? 1 : 0);
            carry = sum / 10 == 0 ? false : true;
            l2 = l2.next;
            l1.val = sum % 10;
            lastL1 = l1;
            l1 = l1.next;
        }
        if (l1 == null){
            lastL1.next = l2;
            l1 = lastL1.next;
        }
        while (l1 != null && carry) {
            sum = l1.val + (carry == true ? 1 : 0);
            carry = sum / 10 == 0 ? false : true;
            l1.val = sum % 10;
            lastL1 = l1;
            l1 = l1.next;
        }

        if (carry) {
            ListNode end = new ListNode(1);
            lastL1.next = end;
        }
        return result;
    }
}