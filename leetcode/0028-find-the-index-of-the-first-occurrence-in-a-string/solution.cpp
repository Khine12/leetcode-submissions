class Solution {
public:
    int strStr(string haystack, string needle) {
        int m = needle.length();
        int n = haystack.length();

        if(m==0)
        {
            return 0;
        }

        for(int windowStart =0; windowStart <= n-m; windowStart ++)
        {
            int i ;
            for(i=0; i<m; i++)
            {
                if(needle[i] != haystack[windowStart + i])
                {
                    break;
                }
            }        
            if (i==m)
            {
                return windowStart;
            }
            
        }
        return -1;
    }
};
