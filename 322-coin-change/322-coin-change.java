class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        
        int[][] dp = new int[n][amount+1];
        
        for(int am = 1;am<=amount;am++){
            if(am%coins[0] == 0){
                dp[0][am] = am/coins[0];
            }else{
                dp[0][am] = (int)1e9;
            }
        }
        
        for(int index=1;index<n;index++){
            for(int am=1;am<=amount;am++){
                int notTake = dp[index-1][am];
                int take = (int)1e9;
                if(coins[index]<=am){
                   take = 1 + dp[index][am-coins[index]]; 
                }
                
                dp[index][am] = Math.min(take,notTake);
            }
        }
        return dp[n-1][amount] >= (int)1e9 ? -1 : dp[n-1][amount];
        
    }
    
    private int minCoins(int index,int amount,int[] coins,int[][] dp){
        if(amount == 0){
            return 0;
        }
        
        
        if(index == 0){
            if(amount%coins[index] == 0){
                return amount/coins[index];
            }else{
                return (int)1e9;
            }
        }
        
        if(dp[index][amount] != -1){
            return dp[index][amount];
        }
        
        int notTake = minCoins(index-1,amount,coins,dp);
        int take = (int)(1e9);
        if(coins[index]<=amount){
            take = 1 + minCoins(index,amount - coins[index],coins,dp);
        }
        return dp[index][amount] = Math.min(take,notTake);
    }
}