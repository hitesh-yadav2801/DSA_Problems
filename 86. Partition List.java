class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode l1 = new ListNode(-1);
        ListNode l2 = new ListNode(-1);
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        while(head != null){
            if(head.val < x){
                temp1.next = head;
                temp1 = temp1.next;
            } else {
                temp2.next = head;
                temp2 = temp2.next;
            }
            head = head.next;
        }
        l2 = l2.next;
        temp1.next = l2;
        temp2.next = null;
        return l1.next;
    }
}
