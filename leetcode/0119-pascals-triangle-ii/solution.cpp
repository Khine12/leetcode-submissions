class Solution {
public:
    int getNum(int row, int col)
    {
        if(row == 0 || col == 0 || row == col) return 1;
        return getNum(row-1,col-1) + getNum(row-1, col);
    }
    vector<int> getRow(int rowIndex) {
        vector<int>ans(rowIndex+1,1);

        for(int i=0; i < rowIndex; ++i)
        {
            for(int j=i; j>0 ; --j)
            {
                ans[j] = ans[j] + ans[j-1];
            }
        }
        return ans;
        
    }
};
