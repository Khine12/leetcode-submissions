class Solution {
    public int maxProfit(int[] prices) {

        int profit = 0;

        int buy = Integer.MAX_VALUE;
        
        for(int price : prices){

            if(price < buy ){

                buy = price;

            }else{

                profit = Math.max(profit,price-buy);
            }
        }
        return profit;
    }
}
