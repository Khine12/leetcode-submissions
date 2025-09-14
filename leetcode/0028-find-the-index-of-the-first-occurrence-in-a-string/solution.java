class Solution {
    public int strStr(String haystack, String needle) {
        int i = haystack.length();
        int j = needle.length();
        
        if (j>i) return -1;
        
        for(int h=0; h<=i-j; h++) {
            
            int n=0;
            
            while (n<j && haystack.charAt(h+n)==needle.charAt(n)) {
                n++;
            }
            
            if(n==j) return h;
        }
        
        return -1;
    }
}
