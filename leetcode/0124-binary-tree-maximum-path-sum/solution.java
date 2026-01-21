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

    int max_path_sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        helper(root);

        return max_path_sum;
        
    }

    public int helper(TreeNode node){

        if(node == null) return 0;

        int left = Math.max(0,helper(node.left));

        int right = Math.max(0,helper(node.right));

        max_path_sum = Math.max(max_path_sum,node.val+left+right);

        return node.val + Math.max(left,right);
    }
}
