class MyQueue {
    private Stack<Integer>s1,s2;
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        s2.push(x);
    }
    
    public int pop() {
        if(!empty()){
            if(!s1.isEmpty()){
                return s1.pop();
            }else{
                while(!s2.isEmpty()){
                    s1.push(s2.pop());
                }
                return s1.pop();
            }
        }else{
            return -1;
        }
    }
    
    public int peek() {
        if(!empty()){
            if(!s1.isEmpty()){
                return s1.peek();
            }else{
                while(!s2.isEmpty()){
                    s1.push(s2.pop());
                }
                return s1.peek();
            }
        }else{
            return -1;
        }
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */