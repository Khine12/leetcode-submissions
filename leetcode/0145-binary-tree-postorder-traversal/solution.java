/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List <Integer> result = new ArrayList<>();
        
        if(root == null) return result;
        
        Stack <TreeNode> stack_1 = new Stack<>();
        
        Stack <TreeNode> stack_2 = new Stack<>();
        
        stack_1.push(root);
        
        while(!stack_1.isEmpty()){
            
            TreeNode curr = stack_1.pop();
            
            stack_2.push(curr);
            
            if(curr.left != null) stack_1.push(curr.left);
            
            if(curr.right != null) stack_1.push(curr.right);
        }
        while(!stack_2.isEmpty()){
            
            result.add(stack_2.pop().val);
        }
        
        return result;
    }
}
