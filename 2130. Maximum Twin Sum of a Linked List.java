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
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode end = reverseList(slow);
        ListNode start = head;
        int maxSum = Integer.MIN_VALUE;
        while(end != null){
            int sum = start.val + end.val;
            maxSum = Math.max(sum, maxSum);
            start = start.next;
            end = end.next;
        }
        return maxSum;
    }
    public ListNode reverseList(ListNode mid) {
        ListNode temp = mid;
        ListNode prev = null;
        while(mid != null){
            mid = mid.next;
            temp.next = prev;
            prev = temp;
            temp = mid;
        }
        return prev;
    }
}
