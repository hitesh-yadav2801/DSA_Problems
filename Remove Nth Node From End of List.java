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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next== null) return null;
              
        ListNode first = head;
        ListNode second = head;
        for(int i=0; i<n;i++){
            second = second.next;       
        }
        
        if(second==null){
            first=first.next;
            head=first;
            return head;
        }
        
        while(second != null && second.next!=null){
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;         
        return head;
    }
}


// follow up in one iteration

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        ListNode prev = head;
        while(n-- > 0){
            cur = cur.next;
            if(n == 0){
                if(cur == null){
                    prev = prev.next;
                    return prev;
                }
                while(cur != null && cur.next != null){
                    prev = prev.next;
                    cur = cur.next;
                }
                prev.next = prev.next.next;
            }
        }
        
        return head;
    }
}
