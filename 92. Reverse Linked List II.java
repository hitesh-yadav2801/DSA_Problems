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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null) return head;
        ListNode l = head;
        ListNode r = head;
        ListNode temp1 = new ListNode(0, head);
        ListNode prev = temp1;
        for(int i = 1; i < left; i++){
            prev = l;
            l = l.next;
        }
        for(int i = 1; i < right; i++){
            r = r.next;
        }
        if(r != null || r.next != null){
            r = r.next;
        } 
        ListNode dummy = r;
        ListNode temp = reverseList(l, r);
        prev.next = temp;
        l.next = dummy;
        return temp1.next;
    }
    public ListNode reverseList(ListNode head, ListNode right) {
        ListNode temp = head;
        ListNode prev = null;
        while(head != right){
            head = head.next;
            temp.next = prev;
            prev = temp;
            temp = head;
        }
        return prev;
    }
}
