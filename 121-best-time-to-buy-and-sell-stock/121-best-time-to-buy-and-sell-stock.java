class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0,minInLeft = prices[0];
        
        for(int i=1;i<prices.length;i++){
            int currProfit = prices[i] - minInLeft;
            profit = Math.max(profit,currProfit);
            minInLeft = Math.min(minInLeft,prices[i]);
        }
        
        return profit;
    }
}