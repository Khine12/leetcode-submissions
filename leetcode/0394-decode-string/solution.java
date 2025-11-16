import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        
        Stack <Integer> currStack = new Stack<>();
        
        Stack <StringBuilder> currStringStack = new Stack<>();
        
        int currNum = 0;
        
        StringBuilder currString = new StringBuilder();
        
        for(char ch : s.toCharArray()){
            
            if(Character.isDigit(ch)){
                
                currNum = currNum * 10 + (ch-'0');
            }
            else if(ch=='['){
                
                currStack.push(currNum);
                
                currStringStack.push(currString);
                
                currNum = 0;
                
                currString = new StringBuilder();
            }
            else if(ch==']'){
                
                int repeat = currStack.pop();
                
                StringBuilder prevString = currStringStack.pop();
                
                StringBuilder expanded = new StringBuilder(prevString);
                
                for(int i=0; i<repeat; i++){
                    
                    expanded.append(currString);
                }
                currString = expanded;
            }
            else{
                
                currString.append(ch);
            }
        }
        return currString.toString();
    }
}
