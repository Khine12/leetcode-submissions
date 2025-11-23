class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int n = arr.length;
        
        int left = 0;
        
        int right = n-k;
        
        while (left < right){
            
            int mid = left + (right - left)/2;
            
            int disLeft = x - arr[mid];
            
            int disRight = arr[mid+k] - x;
            
            if(disLeft > disRight){
                
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        
        List <Integer> result = new ArrayList<>();
        
        for(int i = left; i < left + k; i++){
            
            result.add(arr[i]);
        }
        return result;
    }
}
