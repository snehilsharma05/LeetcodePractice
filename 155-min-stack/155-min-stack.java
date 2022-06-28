class MinStack {
    private long mini = (int)1e10;
    
    Stack<Long> s;
    public MinStack() {
        s = new Stack<>();
    }
    
    public void push(int val) {
        if(s.isEmpty()){
            s.push((long)val);
            mini = val;
        }else if((long)val >= mini){
            s.push((long)val);
        }else if((long)val < mini){
            s.push((long)2*val - mini); //will always be less than val
            mini = val;
        }
    }
    
    public void pop() {
        if(!s.isEmpty()){
            if(s.peek()>=mini){
                s.pop();
            }else if(s.peek() < mini){ //this was a modified value, let's come back to prev min
                mini = 2*mini - s.pop();
            }
        }
    }
    
    public int top() {
        if(!s.isEmpty()){
            if(s.peek()<=mini){ //mini is the topmost value
                return (int)mini;
            }else{
                long peekedVal =  (s.peek());
                return (int)peekedVal;
            }
        }
        return -1;
    }
    
    public int getMin() {
        return (int)mini;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */