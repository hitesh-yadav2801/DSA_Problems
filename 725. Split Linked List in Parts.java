// using K extra space

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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        ListNode temp = head;
        int n = 0;
        while(temp != null){
            temp = temp.next;
            n++;
        }
        int len = n / k;
        int rem = n % k;
        int[] arr = new int[k];
        Arrays.fill(arr, len);
        for(int i = 0; i < k && rem > 0; i++){
            arr[i]++;
            rem--;
        }
        int idx = 0;
        temp = head;
        ListNode prev = null;
        while(temp != null){
            ans[idx] = temp;
            for(int j = 0; j < arr[idx]; j++){
                prev = temp;
                temp = temp.next;
            }
            prev.next = null;
            idx++;
        }
        return ans;
    }
}
