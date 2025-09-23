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
import java.util.*;
class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        
        Map<String,Integer> freq = new HashMap<>();
        
        List<TreeNode> ans = new ArrayList<>();
        
        serialize(root, freq, ans);
        
        return ans;
    }
    private String serialize(TreeNode node, Map<String,Integer> freq, List<TreeNode> ans){
        
        if(node==null) return "#";
                
        String left = serialize(node.left, freq, ans);
        
        String right = serialize(node.right, freq, ans);

        String sig = node.val + ","+ left + ","+ right;
        
        int c = freq.getOrDefault(sig,0);
        
        if(c==1){
            
            ans.add(node);
        }
        freq.put(sig,c+1);
        
        return sig;
    }
}
