class Solution {
public:
    bool isPalindrome(int x) {
        // Negative numbers are not palindromes
        // Numbers ending in 0 are not palindromes unless the number is 0
        if (x<0 || (x != 0 && x%10 == 0))
        {
            return false;
        }

        int reversedHalf =0;
        while(x > reversedHalf)
        {
            reversedHalf = reversedHalf*10 + x%10;
            x/=10;
        }

        // When the length is an odd number , we can get rid of the middle digit by reversedHalf/10
        return x == reversedHalf || x == reversedHalf/10;
        
    }
};
