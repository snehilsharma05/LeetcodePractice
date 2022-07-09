class Solution {
    private static final int MAX = (int)1e9;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] dp = new int[m+1][target+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=target;j++){
                for(int k=0;k<=n;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        int ans = dfs(0,target,0,houses,cost,n,dp);
        return ans == MAX ? -1 : ans;
    }
    
    private int dfs(int index,int target,int lastColor,int[] houses,int[][] cost,int n,int[][][] dp){
        if(target < 0){
            return MAX;
        }
        
        if(index>=houses.length){
            return target == 0 ? 0 : MAX;
        }
        
        if(dp[index][target][lastColor] != -1){
            return dp[index][target][lastColor];
        }
        
        if(houses[index] != 0){ //already colored house
            if(houses[index] != lastColor){
                target--;
            }
            
            return dfs(index+1,target,houses[index],houses,cost,n,dp);
        }
        
        int ans = MAX;
        
        for(int color=1;color<=n;color++){
            ans = Math.min(ans,cost[index][color-1] + dfs(index+1,color != lastColor ? target-1 : target,color,houses,cost,n,dp));
        }
        return dp[index][target][lastColor] = ans;
    }
}