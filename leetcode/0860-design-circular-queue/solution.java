class MyCircularQueue {
    
    private int[] data;
    
    private int size, rear, capacity, front;

    public MyCircularQueue(int k) {
        
        data = new int[k];
        
        size = 0;
        
        rear = 0; 
        
        capacity = k;
        
        front = 0;
    }
    
    public boolean enQueue(int value) {
        
        if(isFull()) return false;
                
        data[rear]=value;
        
        rear = (rear+1)%capacity;
            
        size++;
        
        return true;
    }
    
    public boolean deQueue() {
        
        if(isEmpty()) return false;
        
        front = (front+1)%capacity;
        
        size--;
        
        return true;
    }
    
    public int Front() {
        
        if(isEmpty()) return -1;
        
        return data[front];
    }
    
    public int Rear() {
        
        if(isEmpty()) return -1;
        
        return data[(rear-1+capacity)%capacity];
    }
    
    public boolean isEmpty() {
        
        return size==0;
    }
    
    public boolean isFull() {
        
        return size==capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
