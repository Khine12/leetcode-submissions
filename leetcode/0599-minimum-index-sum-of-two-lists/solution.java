class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        
        Map<String,Integer> idx = new HashMap<>();
        
        for(int i=0; i<list1.length;i++){
            
            idx.put(list1[i],i);
        }
        
        List<String> ans = new ArrayList<>();
        
        int min_sum = Integer.MAX_VALUE;
                
        for(int j=0; j<list2.length; j++){
            
            if(j>min_sum) break;
            
            Integer i = idx.get(list2[j]);
                        
            if(i != null){
                
                int sum = i + j;
                
                if(sum < min_sum){
                    
                    min_sum = sum;
                    
                    ans.clear();
                    ans.add(list2[j]);
                }
                else if(sum == min_sum){
                    
                    ans.add(list2[j]);
                }
            }
        }
        return ans.toArray(new String[0]);
    }
}
