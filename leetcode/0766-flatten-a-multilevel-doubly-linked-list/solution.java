/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        
        if(head==null) return head;
        
        Node khine = new Node();
        
        Node prev = khine;
        
        Deque<Node> st = new ArrayDeque<>();
        
        st.push(head);
        
        while(!st.isEmpty()){
            
            Node curr = st.pop();
            
            prev.next = curr;
            
            curr.prev = prev;
            
            if(curr.next !=null) st.push(curr.next);
            
            if(curr.child != null){
                
                st.push(curr.child);
                
                curr.child = null;
            
            }
            
            prev = curr;
        }
        khine.next.prev = null;
        
        return khine.next;
    }
}
