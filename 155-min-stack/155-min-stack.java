class MinStack {
    private class Pair{
        int val,min;
        Pair(int val,int min){
            this.val = val;
            this.min = min;
        }
    }
    
    Stack<Pair> s;
    public MinStack() {
        s = new Stack<>();
    }
    
    public void push(int val) {
        if(s.isEmpty()){
            s.push(new Pair(val,val));
        }else{
            s.push(new Pair(val,Math.min(s.peek().min,val)));
        }
    }
    
    public void pop() {
        s.pop();
    }
    
    public int top() {
        if(s.isEmpty()){
            return -1;
        }else{
            return s.peek().val;
        }
    }
    
    public int getMin() {
        if(s.isEmpty()){
            return -1;
        }else{
            return s.peek().min;
        }
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