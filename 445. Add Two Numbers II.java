// Using extra space

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        int carry = 0;
        ListNode current = new ListNode(-1);
        ListNode dummy = current;
        while(l1 != null || l2 != null || carry != 0){
            int sum = 0;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            if(carry != 0){
                sum += carry;
            }
            dummy.next = new ListNode(sum % 10);
            dummy = dummy.next;
            carry = sum / 10;
        }
        return reverse(current.next);
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null, cur = head;
        while(head != null){
            head = head.next;
            cur.next = prev;
            prev = cur;
            cur = head;
        }
        return prev;
    }
}
