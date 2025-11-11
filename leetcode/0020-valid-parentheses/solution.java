import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isValid(String s) {
        
        if((s.length()&1)==1) return false;
        
        Deque<Character> st = new ArrayDeque<>();
        
        for(char c : s.toCharArray()){
            
            if(c=='['){
                
                st.push(']');
            }
            else if(c=='{'){
                
                st.push('}');
            }
            else if(c=='('){
                
                st.push(')');
            }
            else{
                
                if(st.isEmpty() || st.pop() != c) return false;
            }
        }
        return st.isEmpty();
    }
}
