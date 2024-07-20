class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int minPrice = INT_MAX;
        int maxProfit = 0;
        
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; // Track the minimum price so far
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice; // Calculate the profit
            }
        }
        
        return maxProfit;
    }
};

