import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int evalRPN(String[] tokens) {
        
        Deque<Integer> st = new ArrayDeque<>();
        
        for(String t : tokens){
            
            switch(t){
                    
                case "+":
                    
                    st.push(st.pop()+st.pop());
                    break;
                    
                case "-":{
                    
                    int a = st.pop();
                    int b = st.pop();
                    
                    st.push(b-a);
                    break;
                }    
                case "*":
                    
                    st.push(st.pop()*st.pop());
                    break;
                    
                case "/":{
                    
                    int a = st.pop();
                    int b = st.pop();
                    
                    st.push(b/a);
                    break;
                }
                default:
                    
                    st.push(Integer.parseInt(t));
            }
        }
        return st.pop();
    }
}
