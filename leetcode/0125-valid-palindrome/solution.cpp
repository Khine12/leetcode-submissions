class Solution {
public:
    bool isPalindrome(string s) {
        string filtered_string , reversed_string;

        for(char ch : s)
        {
            if(isalnum(ch))
            {
                filtered_string += tolower(ch);
            }
        }

        reversed_string = filtered_string;

        reverse(reversed_string.begin(), reversed_string.end());
        
        return filtered_string == reversed_string;

    }
    
};



