class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    dp[i][j] = 0;
                }else if(i == 0 && j == 0){
                    dp[i][j] = 1;
                }else {
                    int top = (i-1>=0) ? dp[i-1][j] : 0;
                    int left = (j-1>=0) ? dp[i][j-1] : 0;
                    dp[i][j] = top + left;
                }
            }
        }
        
        return dp[m-1][n-1];
        //return countPaths(m-1,n-1,grid,dp);
    }
    
    private int countPaths(int m,int n,int[][] grid,int[][] dp){
        if(m <0 || n< 0 || grid[m][n] == 1){
            return 0;
        }
        
        if(m == 0 && n == 0){
            return 1;
        }
        
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        
        int top = countPaths(m-1,n,grid,dp);
        int left = countPaths(m,n-1,grid,dp);
        return dp[m][n] = top + left;
    }
}