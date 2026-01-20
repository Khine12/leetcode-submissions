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
    public int goodNodes(TreeNode root) {
        
        return helper(root,Integer.MIN_VALUE);
    }

    private int helper(TreeNode node, int maxSoFar){

        if(node == null) return 0;

        int count = 0;

        if(node.val >= maxSoFar) count = 1;

        int newMax = Math.max(maxSoFar,node.val);

        count += helper(node.left,newMax);

        count += helper(node.right,newMax);

        return count;
    }
}
