class MyQueue {
    
    private Stack <Integer> in;
    
    private Stack <Integer> out;

    public MyQueue() {
        
        in = new Stack<>();
        
        out = new Stack<>();
    }
    
    public void push(int x) {
        
        in.push(x);
    }
    
    public int pop() {
        
        moveIfNeeded();
        
        return out.pop();
    }
    
    public int peek() {
        
        moveIfNeeded();
        
        return out.peek();
    }
    
    public boolean empty() {
        
        return in.isEmpty() && out.isEmpty();
    }
    
    private void moveIfNeeded(){
        
        if(out.isEmpty()){
            
            while(!in.isEmpty()){
                
                out.push(in.pop());
            }
        }
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
