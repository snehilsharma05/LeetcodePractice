class Solution {
    public int coinChange(int[] coins, int totalAmount) {
        int n = coins.length;
        int[][] dp = new int[n][totalAmount+1];
        
        for(int amount=0;amount<=totalAmount;amount++){
            if(amount % coins[0] == 0){
                dp[0][amount] = amount/coins[0];
            }else{
                dp[0][amount] = (int)1e9;
            }
        }
        
        for(int index=1;index<n;index++){
            for(int amount=0;amount<=totalAmount;amount++){
                int notTake = 0 + dp[index-1][amount];
                int take = (int)1e9;
                if(coins[index]<=amount){
                    take = 1 + dp[index][amount-coins[index]];
                }
                dp[index][amount] = Math.min(take,notTake);
            }
        }
        return dp[n-1][totalAmount] == (int)1e9 ? -1 : dp[n-1][totalAmount];
        
        //int ans = minCoins(n-1,coins,amount,dp);
        
    }
    private int minCoins(int index,int[] coins,int amount,int[][] dp){
        if(index == 0){
            if(amount % coins[index] == 0){
                return amount/coins[index];
            }else{
                return (int)1e9;
            }
        }
        
        if(dp[index][amount] != -1){
            return dp[index][amount];
        }
        
        int notTake = 0 + minCoins(index-1,coins,amount,dp);
        int take = (int)1e9;
        if(amount>=coins[index]){
            take = 1 + minCoins(index,coins,amount - coins[index],dp);
        }
        return dp[index][amount] = Math.min(take,notTake);
    }
}