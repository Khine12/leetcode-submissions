#include<iostream>
#include<vector>
#include<string>
#include<algorithm>
#include<climits>

using namespace std;

class Solution {
    public:
    string longestCommonPrefix(vector<string>& strs)
    {
        if(strs.empty())
        return "";

        int minimumLength = INT_MAX;

        // finding the string with the minimum amount of chars.
        for(const string&str : strs)
        {
            minimumLength = min(minimumLength,(int)str.length());
        }

        // Preparation for binary search
        int low = 1;
        int high = minimumLength;

        while(low <= high)
        {
            int middle = (low + high)/2;

            // If this is the common prefix, try to make it longer to see if we will succeed.
            if(isCommonPrefix(strs,middle))
            low = middle + 1;
            else
            high = middle -1;
        }

        return strs[0].substr(0,(low+high)/2);
    }

    private:
    bool isCommonPrefix(const vector<string>&strs, int len)
    {
        string str1 = strs[0].substr(0,len);

        for(int i = 1; i<strs.size(); ++i)
        {
            if(strs[i].find(str1) !=0)
            return false;
        }
        return true;
    }

    int main()
    {
        Solution sol;
        vector<string>strs1 = {"flower","flow","flight"};
        vector<string>strs2 = {"dog","racecar","car"};

        cout << "Longest Common Prefix for strs1 : " << sol.longestCommonPrefix(strs1) << endl;
        cout << "Longest Common Prefix for strs2 : " << sol.longestCommonPrefix(strs2) << endl;

        return 0;
    }

};
