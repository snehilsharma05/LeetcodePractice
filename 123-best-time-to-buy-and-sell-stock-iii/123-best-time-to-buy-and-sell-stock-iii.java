class Solution {
    public int maxProfit(int[] prices) {
        int k = 2, n = prices.length;
        int[][] dp = new int[prices.length+1][2*k+1];
        
        for(int index = n-1;index>=0;index--){
            for(int transactionNumber = 3;transactionNumber >= 0;transactionNumber--){
                if(transactionNumber % 2 == 0){
                    dp[index][transactionNumber] = Math.max(-prices[index] +dp[index+1][transactionNumber+1],
                                    0 + dp[index+1][transactionNumber]
                                   );
                }else{
                    dp[index][transactionNumber] = Math.max(+prices[index] + dp[index+1][transactionNumber+1],
                                    0 + dp[index+1][transactionNumber]);
                }
            }
        }
        
        return dp[0][0];
        //return maxProfit(0,0,prices,dp);
    }
    
    private int maxProfit(int index,int transactionNumber,int[] prices,int[][] dp){
        if(index == prices.length || transactionNumber == 4){
            return 0;
        }
        if(dp[index][transactionNumber] != -1){
            return dp[index][transactionNumber];
        }
        
        if(transactionNumber % 2 == 0){
            return dp[index][transactionNumber] = Math.max(-prices[index] + maxProfit(index+1,transactionNumber+1,prices,dp),
                            0 + maxProfit(index+1,transactionNumber,prices,dp)
                           );
        }else{
            return dp[index][transactionNumber] = Math.max(+prices[index] + maxProfit(index+1, transactionNumber+1,prices,dp),
                            0 + maxProfit(index+1,transactionNumber,prices,dp));
        }
    }
}