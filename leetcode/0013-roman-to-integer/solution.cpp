#include<unordered_map>
#include<string>

using namespace std;

class Solution {
public:
    int romanToInt(string s) {
        // Define the value of each Roman numeral symbol
        unordered_map <char, int>roman_values = {
            {'I',1},{'V',5},{'X',10},{'L',50},{'C',100},{'D',500},{'M',1000}
        };
        int total = 0;
        int n = s.length();

        for(int i=0; i<n; ++i)
        {
            // If the current value is less than the next value, subtract it 
            if(i<n-1 && roman_values[s[i]] < roman_values[s[i+1]])
            {
                total -= roman_values[s[i]];
            }
            else
            {
                // Otherwise , add it to the total 
                total += roman_values[s[i]];
            }
        }
        return total;
    }
};
