class MyStack {
    private Queue<Integer> q1 ,q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        while(!q1.isEmpty()){
            q2.add(q1.poll());
        }
        
        q1.add(x);
        while(!q2.isEmpty()){
            q1.add(q2.poll());
        }
    }
    
    public int pop() {
        if(!empty()){
            return q1.poll();
        }else{
            return -1;
        }
    }
    
    public int top() {
        if(!empty()){
            return q1.peek();
        }else{
            return -1;
        }
    }
    
    public boolean empty() {
        return q1.size() == 0;
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