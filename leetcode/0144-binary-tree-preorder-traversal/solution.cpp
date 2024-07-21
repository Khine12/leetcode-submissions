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
public:
    vector<int> preorderTraversal(TreeNode* root) 
    {
        if(root == nullptr)
        {
            return vector<int>();
        }

        vector<TreeNode*>stack = {root};
        vector<int>output;

        while (!stack.empty())
        {
            root = stack.back();
            stack.pop_back();

            if(root != nullptr)
            {
                output.push_back(root->val);

                if(root->right != nullptr)
                {
                    stack.push_back(root->right);
                }
                
                if(root->left != nullptr)
                {
                    stack.push_back(root->left);
                }
            
            }
        }
        return output;
    }
};
