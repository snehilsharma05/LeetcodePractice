class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return unique(obstacleGrid,0,0,dp);
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