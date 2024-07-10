class Solution {
public:
    int lengthOfLastWord(string s) {
        // trim the trailing spaces
        int p = s.length() - 1;
        while(p>=0 && s[p] == ' ')
        {
            p--;
        }
        
        // compute the length of last word
        int length = 0;
        while (p>=0 && s[p] != ' ')
        {
            p--;
            length++;
        }
        return length;
    }
};
