class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int zeros = 0;
        
        for(int i=0; i<n; i++)
            if (arr[i]==0) {
                zeros++;
            }
        
        for(int i=n-1; i>=0; i--) {
            int newIndex = i + zeros;
        
            if (newIndex<n) {
                arr[newIndex] = arr[i];
            }
            if (arr[i]==0) {
                zeros--;
                
                if (i+zeros<n) {
                    arr[i+zeros] = 0;
                }
            }
        }
    }
}
