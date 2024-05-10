class Solution {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> st = new Stack();
        ListNode cur = head;
        while(cur != null){
            st.push(cur);
            cur = cur.next;
        }
        cur = st.pop();
        ListNode resHead = new ListNode(cur.val);
        int maxVal = cur.val;

        while(!st.isEmpty()){
            cur = st.pop();
            if(cur.val < maxVal){
                continue;
            } else {
                ListNode newNode = new ListNode(cur.val);
                newNode.next = resHead;
                resHead = newNode;
                maxVal = cur.val;
            }
        }
        return resHead;
    }
}
