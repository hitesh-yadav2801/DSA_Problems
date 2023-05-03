class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    public void push(int x) {
        q1.offer(x);
    }
    
    public int pop() {
        while(q1.size() != 1){
            int temp = q1.poll();
            q2.offer(temp);
        }
        int dummy = q1.peek();
        q1.poll();
        while(!q2.isEmpty()){
            int temp = q2.poll();
            q1.offer(temp);
        }
        return dummy;
    }
    
    public int top() {
        while(q1.size() != 1){
            int temp = q1.poll();
            q2.offer(temp);
        }
        int dummy = q1.peek();
        q2.offer(dummy);
        q1.poll();
        while(!q2.isEmpty()){
            int temp = q2.poll();
            q1.offer(temp);
        }
        return dummy;
    }
    
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
