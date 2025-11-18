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
    
    private int postIndex;
    
    private int[] postorder;
    
    Map <Integer, Integer> inorderIndexMap;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        this.postorder = postorder;
        
        this.postIndex = postorder.length-1;
        
        inorderIndexMap = new HashMap<>();
        
        for(int i=0; i<inorder.length; i++){
            
            inorderIndexMap.put(inorder[i],i);
        }
        
        return build(0,inorder.length-1);
    }
    
    private TreeNode build(int inLeft, int inRight){
        
        if(inLeft>inRight) return null;
        
        int rootVal = postorder[postIndex];
        
        postIndex--;
        
        TreeNode root = new TreeNode(rootVal);
        
        int index = inorderIndexMap.get(rootVal);
        
        root.right = build(index+1, inRight);
        
        root.left = build(inLeft, index-1);
        
        return root;
    }
}
