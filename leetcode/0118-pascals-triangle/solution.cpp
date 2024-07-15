#include <vector>
using namespace std;

class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> triangle;
        if (numRows == 0) return triangle;
        
        triangle.push_back(vector<int>(1, 1));

        for (int RowNum = 1; RowNum < numRows; RowNum++) {
            vector<int> row(RowNum + 1, 1);
            const vector<int>& PreRow = triangle[RowNum - 1];

            for (int j = 1; j < RowNum; j++) {
                row[j] = PreRow[j - 1] + PreRow[j];
            }

            triangle.push_back(row);
        }
        return triangle;
    }
};

