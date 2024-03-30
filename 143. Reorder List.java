class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rev = reverse(slow);
        ListNode cur = head;
        while(rev.next != null){
            ListNode tempCur = cur.next;
            cur.next = rev;

            ListNode tempRev = rev.next;
            rev.next = tempCur;

            cur = tempCur;
            rev = tempRev;
        }
    }
    ListNode reverse(ListNode head){
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
