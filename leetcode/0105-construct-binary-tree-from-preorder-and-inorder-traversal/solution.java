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
    
    private int preorderIndex;
    
    private int[] preorder;
    
    Map <Integer,Integer> inorderIndexMap;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        this.preorder = preorder;
        
        this.preorderIndex = 0;
        
        inorderIndexMap = new HashMap<>();
        
        for(int i=0; i<inorder.length; i++){
            
            inorderIndexMap.put(inorder[i],i);
        }
        
        return build(0,inorder.length-1);
    }
    
    private TreeNode build(int left, int right){
        
        if(left>right) return null;
        
        int rootVal = preorder[preorderIndex];
        
        preorderIndex++;
        
        TreeNode root = new TreeNode(rootVal);
        
        int index = inorderIndexMap.get(rootVal);
        
        root.left = build(left,index-1);
        
        root.right = build(index+1, right);
        
        return root;
    }
    
    
}
