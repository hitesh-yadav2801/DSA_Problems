class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode temp = list1, dummy = list1;
        for(int i = 0; i < a - 1; i++){
            temp = temp.next;
        }
        for(int i = 0; i <= b; i++){
            dummy = dummy.next;
        }
        temp.next = list2;
        temp = temp.next;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = dummy;
        return list1;
    }
}
