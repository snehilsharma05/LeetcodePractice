class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        
        int aheadBuy = 0,aheadNotBuy = 0;
        
        for(int index = n-1;index>=0;index--){
                
            int[] curr = new int[2];
            
            int currBuy = Math.max(-prices[index] - fee + aheadNotBuy,
                                   0 + aheadBuy);
                
            int currNotBuy = Math.max(+prices[index] + aheadBuy,
                                   0 +aheadNotBuy);
            
            
            aheadNotBuy =  currNotBuy;
            aheadBuy = currBuy;
        }
        
        return aheadBuy;
        
        //return maxProfit(0,1,prices,fee,dp);
    }
    private int maxProfit(int index,int buy,int[] prices,int fee,int[][] dp){
        if(index>=prices.length){
            return 0;
        }
        
        if(dp[index][buy] != -1){
            return dp[index][buy];
        }
        
        if(buy == 1){
            return dp[index][buy] = Math.max(-prices[index] - fee + maxProfit(index+1, 0, prices,fee,dp),
                           0 + maxProfit(index+1,1,prices,fee,dp));
        }else{
            return dp[index][buy] = Math.max(+prices[index] + maxProfit(index+1,1,prices,fee,dp),
                           0 + maxProfit(index+1,0,prices,fee,dp));
        }
    }
}