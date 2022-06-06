class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    dp[i][j] = 0;
                }else if(i == 0 && j == 0){
                    dp[i][j] = 1;
                }else{
                    int left = 0,up = 0;
                    if(i>0){
                        up += dp[i-1][j];
                    }
                    if(j>0){
                        left += dp[i][j-1];
                    }
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[m-1][n-1];
        //return ways(m-1,n-1,obstacleGrid,dp);
    }
    private int ways(int m,int n,int[][] grid,int[][] dp){
        if(m<0 || n<0 || grid[m][n] == 1){
            return 0;
        }
        
        if(m == 0 && n == 0){
            return 1;
        }
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        
        return dp[m][n] = ways(m-1,n,grid,dp) + ways(m,n-1,grid,dp);
    }
}