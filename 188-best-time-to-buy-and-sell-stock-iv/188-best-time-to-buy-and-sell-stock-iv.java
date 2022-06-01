class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2*k+1];
        
        for(int index = n-1;index>=0;index--){
            for(int transNum = 2*k-1;transNum>=0;transNum--){
                if(transNum % 2 == 0){
                     dp[index][transNum] =  Math.max(-prices[index] + dp[index+1][transNum+1],
                            0 + dp[index+1][transNum]);
                }else{
                     dp[index][transNum] = Math.max(+prices[index] + dp[index+1][transNum+1],
                                    0 + dp[index+1][transNum]);
                }
            }
        }
        return dp[0][0];
        //return maxProfit(0,0,prices,k,dp);
    }
    private int maxProfit(int index,int transNum,int[] prices,int k,int[][] dp){
        if(index >= prices.length || transNum == 2*k){
            return 0;
        }
        if(dp[index][transNum] != -1){
            return dp[index][transNum];
        }
        
        if(transNum % 2 == 0){
            return dp[index][transNum] =  Math.max(-prices[index] + maxProfit(index+1,transNum+1,prices,k,dp),
                            0 + maxProfit(index+1,transNum,prices,k,dp));
        }else{
            return dp[index][transNum] = Math.max(+prices[index] + maxProfit(index+1,transNum+1,prices,k,dp),
                            0 + maxProfit(index+1,transNum,prices,k,dp));
        }
    }
}