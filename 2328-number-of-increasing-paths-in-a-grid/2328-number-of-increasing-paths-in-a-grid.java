class Solution {
    private static final int mod = (int)1e9+7;
    public int countPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long[][] dp = new long[m][n];
        for(long[] row:dp){
            Arrays.fill(row,-1);
        }
        
        long ans = 0L;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans = (ans + dfs(i,j,0,grid,dp))%mod; 
            }
        }
        
        return (int)ans;
    }
    
    private long dfs(int i,int j,int prevVal,int[][] grid,long[][] dp){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length){
            return 0;
        }
        
        if(grid[i][j]<=prevVal){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        dp[i][j] = 1; //everyone is increasing in itself
        
        long up = dfs(i-1,j,grid[i][j],grid,dp);
        long down = dfs(i+1,j,grid[i][j],grid,dp);
        long left = dfs(i,j-1,grid[i][j],grid,dp);
        long right = dfs(i,j+1,grid[i][j],grid,dp);
        
        dp[i][j] = (dp[i][j] + up+down+left+right)%mod;
        return dp[i][j];
    }
}