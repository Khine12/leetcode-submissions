class Solution {
    public int heightChecker(int[] heights) {
        
        int n = heights.length;
        
        int[] expected = new int[n];
        
        
        for (int j=0; j<n; j++) {
            
            expected[j] = heights[j];
            
        }
        
        java.util.Arrays.sort(expected);
        
        int numberOfIndices =0;
        
        for (int i=0; i<n;i++) {
            
            if (heights[i] != expected[i]) {
                numberOfIndices++;
            }
        }
        
        return numberOfIndices;
    }
}
