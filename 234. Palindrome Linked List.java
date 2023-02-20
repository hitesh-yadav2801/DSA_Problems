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
 
 
 // Not an optimal Solution extra space is used O(n)
class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> st = new Stack<>();
        ListNode temp = head;
        while(temp != null){
            st.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            if(st.peek() != temp.val) return false;
            st.pop();
            temp = temp.next;
        }
        return true;
    }
}


// Better solution


class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode last = reverseList(slow); 
        ListNode start = head;
        while(last != null){
            if(start.val != last.val){
                return false;
            }
            start = start.next;
            last = last.next;
        } 
        return true;      
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
