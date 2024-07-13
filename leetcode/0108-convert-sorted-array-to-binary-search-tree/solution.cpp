/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
    vector <int> nums;
public:
    TreeNode* helper (int left, int right)
    {
        if(left > right) return nullptr;

        // always choose right middle node as a root
        int p = (left + right)/2;
        if ((left + right)%2 == 1) ++ p;

        // preorder traversal : node -> left -> right
        TreeNode* root = new TreeNode(nums[p]);
        root-> left = helper (left, p-1);
        root -> right = helper (p+1 , right);
        return root;
    }
public:
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        this->nums = nums;
        return helper (0,nums.size() -1);
    }
};
