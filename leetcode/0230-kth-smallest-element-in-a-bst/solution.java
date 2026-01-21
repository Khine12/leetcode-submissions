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

    int count = 0, answer= 0;

    boolean found = false;

    public int kthSmallest(TreeNode root, int k) {

        inorder(root,k);

        return answer;
    }

    private void inorder(TreeNode node, int k){

        if(node == null || found) return;

        if(found) return;

        inorder(node.left,k);

        count++;

        if(count == k){

            answer = node.val;

            found = true;

            return;
        }

        inorder(node.right,k);
    }
}
