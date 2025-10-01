class MyLinkedList {
    
    private static class Node{
        
        int val;
        
        Node prev, next;
        
        Node(int v) {this.val=v;}
    }
    
    private final Node head;
        
    private final Node tail;
        
    private int size;

    public MyLinkedList() {
        
        head = new Node(0);
        
        tail = new Node(0);
        
        head.next = tail;
        
        tail.prev = head;
        
        size = 0;
    }
    
    public int get(int index) {
        
        Node node = nodeAt(index);
        
        return node == null ? -1 : node.val;
    }
    
    public void addAtHead(int val) {
        
        insertBetween(new Node(val),head,head.next);
    }
    
    public void addAtTail(int val) {
        
        insertBetween(new Node(val),tail.prev,tail);
    }
    
    public void addAtIndex(int index, int val) {
        
        if(index>size) return;
        
        if(index<0) index=0;
        
        Node succ = (index==size) ? tail : nodeAt(index);
        
        if(succ==null) return;
        
        Node pred = succ.prev;
        
        insertBetween(new Node(val),pred,succ);
    }
    
    public void deleteAtIndex(int index) {
        
        Node target = nodeAt(index);
        
        if(target==null) return;
        
        unlink(target);
    }
    
    private Node nodeAt(int index){
        
        if(index<0 || index>=size) return null;
        
        Node cur;
        
        if(index < size-index){
            
            cur = head.next;
            
            for(int i=0; i<index; i++) cur = cur.next;
        } 
        else{
            
            cur = tail.prev;
            
            for(int i=size-1; i>index; i--) cur = cur.prev;
        }
        return cur;
    }
    
    private void insertBetween(Node node, Node pred, Node succ){
        
        node.prev = pred;
        
        node.next = succ;
        
        pred.next = node;
        
        succ.prev = node;
        
        size++;
    }
    
    private void unlink(Node node){
        
        Node pred = node.prev, succ = node.next;
        
        pred.next = succ;
        
        succ.prev = pred;
        
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
