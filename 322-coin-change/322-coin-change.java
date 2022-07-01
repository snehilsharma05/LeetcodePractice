class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        
        int[][] dp = new int[n][amount+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        
        int ans = minCoins(n-1,amount,coins,dp);
        if(ans >= (int)1e9){
            return -1;
        }
        return ans;
    }
    
    private int minCoins(int index,int amount,int[] coins,int[][] dp){
        if(amount == 0){
            return 0;
        }
        
        if(dp[index][amount] != -1){
            return dp[index][amount];
        }
        
        if(index == 0){
            if(amount%coins[index] == 0){
                return amount/coins[index];
            }else{
                return (int)1e9;
            }
        }
        
        int notTake = minCoins(index-1,amount,coins,dp);
        int take = (int)(1e9);
        if(coins[index]<=amount){
            take = 1 + minCoins(index,amount - coins[index],coins,dp);
        }
        return dp[index][amount] = Math.min(take,notTake);
    }
}