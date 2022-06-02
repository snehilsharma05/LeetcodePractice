class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        
        return maxProfit(0,1,prices,fee,dp);
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