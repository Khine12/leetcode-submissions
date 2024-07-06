#include<iostream>
#include<stack>
#include<unordered_map>
#include<string>

using namespace std;

class Solution {
public:
    bool isValid(const string& s) {
        unordered_map < char , char > map = {{'(',')'},{'{','}'},{'[',']'}};
        stack<char>stack;
        for(char c : s)
        {
            if(map.find(c) != map.end())
            {
                // if the character is an opening bracket,push it onto the stack
                stack.push(c);
            }
            else
            {
                // IF the stack is empty or the top of the stack doesn't match the closing bracket
                if(stack.empty() || map[stack.top()] !=c)
                {
                    return false;
                }
                // Pop the matching opening bracket
                stack.pop();
            }
        }

        // If the stack is empty, all the brackets are properly closed
        return stack.empty();
    }

};


