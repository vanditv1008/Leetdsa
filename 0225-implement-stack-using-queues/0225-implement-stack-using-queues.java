class MyStack {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    public MyStack() {
    }
    public void push(int x) {
        q1.add(x);
    }
    public int pop() {   // Move all except the last element to q2
        while(q1.size() > 1) {
            q2.add(q1.remove());
        }
        // Last element is the stack top
        int ans = q1.remove();
        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return ans;
    }

    public int top() {
        while(q1.size() > 1) {
            q2.add(q1.remove());
        }
        // Last element = top
        int ans = q1.peek();
        // Put it back because top() should NOT remove
        q2.add(q1.remove());
        // Swap queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return ans;
    }

    public boolean empty() {
        return q1.isEmpty();
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