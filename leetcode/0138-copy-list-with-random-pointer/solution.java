/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        for(Node curr=head; curr != null; curr = curr.next.next){
            
            Node copy = new Node(curr.val);
            
            copy.next = curr.next;
            
            curr.next = copy;
            
            
        }
        
        for(Node curr=head; curr != null; curr = curr.next.next){
            
            if(curr.random != null){
                
                curr.next.random = curr.random.next;
            }
        }
        
        Node dummy = new Node (0), tail = dummy;
        
        for(Node curr=head; curr !=null; ){
            
            Node copy = curr.next;
                        
            tail.next = copy;
            
            tail = copy;
            
            curr.next = copy.next;
            
            curr = curr.next;
        }
        return dummy.next;
    }
}
