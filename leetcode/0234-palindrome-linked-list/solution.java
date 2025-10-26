/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        
        if(head==null || head.next==null) return true;
        
        ListNode fast = head, slow = head;
        
        while(fast!=null && fast.next!=null){
            
            slow = slow.next;
            
            fast = fast.next.next;
        }
        
        ListNode second = reverse(slow);
        
        ListNode first = head;
        
        while(second != null){
            
            if(first.val != second.val) return false;
            
            first = first.next;
            second = second.next;
        }
        return true;
    }
    
    private ListNode reverse(ListNode head){
        
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null){
            
            ListNode next = curr.next;
            
            curr.next = prev;
            
            prev = curr;
            
            curr = next;
        }
        return prev;
    }
}
