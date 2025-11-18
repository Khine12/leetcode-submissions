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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        if (root == null) return false;
        
        Stack <TreeNode> nodeStack = new Stack<>();
        
        Stack <Integer> sumStack = new Stack<>();
        
        nodeStack.push(root);
        
        sumStack.push(root.val);
        
        while(!nodeStack.isEmpty()){
            
            TreeNode curr = nodeStack.pop();
            
            int currSum = sumStack.pop();
            
            if(curr.left == null && curr.right == null){
                
                if(currSum == targetSum){
                    
                    return true;
                }
            }
            
            if(curr.right != null){
                
                nodeStack.push(curr.right);
                
                sumStack.push(currSum + curr.right.val);
            }
            
            if(curr.left != null){
                
                nodeStack.push(curr.left);
                
                sumStack.push(currSum + curr.left.val);
            }
        }
        return false;
    }
}
