class MyStack {
    private Queue<Integer> q;
    public MyStack() {
        q = new LinkedList<>();
    }
    
    public void push(int x) {
        q.add(x);
        int n = q.size();
        for(int i=0;i<n-1;i++){
            q.add(q.poll());
        }
    }
    
    public int pop() {
        if(!empty()){
            return q.poll();
        }else{
            return -1;
        }
    }
    
    public int top() {
        if(!empty()){
            return q.peek();
        }else{
            return -1;
        }
    }
    
    public boolean empty() {
        return q.size()==0;
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