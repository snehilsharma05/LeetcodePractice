class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0){
            return 0;
        }
        int minInLeft = prices[0],profit = 0;
        
        for(int i=1;i<n;i++){
            profit = Math.max(profit,prices[i] - minInLeft);
            minInLeft = Math.min(minInLeft,prices[i]);
        }
        return profit;
    }
}