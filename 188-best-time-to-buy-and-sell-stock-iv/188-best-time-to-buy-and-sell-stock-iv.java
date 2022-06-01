class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2*k+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        
        return maxProfit(0,0,prices,k,dp);
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