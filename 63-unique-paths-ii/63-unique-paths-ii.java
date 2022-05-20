class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m+1][n+1];
        dp[m-1][n-1] = 1;
        
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else if(i== m-1 && j == n-1){
                    dp[i][j] = 1;
                }else{
                    int right = 0;
                    int down = 0;
                    if(j<n-1){
                        right += dp[i][j+1];
                    }
                    if(i<m-1){
                        down += dp[i+1][j];
                    }
                    dp[i][j] = right + down;
                }
            }
        }
        return dp[0][0];
        //return unique(obstacleGrid,0,0,dp);
    }
    
    private int unique(int[][] grid,int m,int n,int[][] dp){
        if(m>=grid.length || n>=grid[0].length || grid[m][n] == 1){
            return 0;
        }
        
        if(m == grid.length-1 && n == grid[0].length-1){
            return 1;
        }
        
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        
        int right = unique(grid,m,n+1,dp);
        int down = unique(grid,m+1,n,dp);
        return  dp[m][n] = right + down;
    }
}