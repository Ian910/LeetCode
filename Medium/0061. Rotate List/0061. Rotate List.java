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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        ListNode node = head, rotateTail = head;
        int times = 1, rotateTimes;
        while (node.next != null) {
            times++;
            node = node.next;
        }
        rotateTimes = k % times;
        if (rotateTimes == 0) return head;
        node.next = head;
        while (times-- > (rotateTimes + 1)) rotateTail = rotateTail.next;
        head = rotateTail.next;
        rotateTail.next = null;

        return head;
    }
}