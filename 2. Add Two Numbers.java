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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode dummy = temp;
        int carry = 0;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            temp.next = new ListNode(sum % 10);
            carry = sum / 10;
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 == null){
            while(l2 != null){
                int sum = l2.val + carry;
                temp.next = new ListNode(sum % 10);
                carry = sum / 10;
                temp = temp.next;
                l2 = l2.next;
            }
        } else if(l2 == null){
            while(l1 != null){
                int sum = l1.val + carry;
                temp.next = new ListNode(sum % 10);
                carry = sum / 10;
                temp = temp.next;
                l1 = l1.next;
            }
        }
        if(carry != 0){
            temp.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
