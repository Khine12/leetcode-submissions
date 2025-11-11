import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int n = temperatures.length;
        
        int[] ans = new int[n];
        
        Deque<Integer> st = new ArrayDeque<>();
        
        for(int i=0; i<n; i++){
            
            while(!st.isEmpty() && temperatures[i]>temperatures[st.peek()]){
                
                int j = st.pop();
                
                ans[j] = i-j;
            }
            st.push(i);
        }
        return ans;
    }
}
