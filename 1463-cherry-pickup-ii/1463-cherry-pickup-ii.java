class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return pickMax(0,0,n-1,grid,dp);
    }
    private int pickMax(int i,int j1,int j2,int[][] grid,int[][][] dp){
        if(j1<0 || j2<0 || j1 >= grid[0].length || j2 >= grid[0].length){
            return (int)-1e9;
        }
        if(i == grid.length-1){
            if(j1 == j2){
                return grid[i][j1];
            }else{
                return grid[i][j1] + grid[i][j2];
            }
        }
        
        if(dp[i][j1][j2] != -1){
            return dp[i][j1][j2];
        }
        
        int max = 0;
        for(int dj1= -1;dj1<=1;dj1++){
            for(int dj2= -1;dj2<=1;dj2++){
                if(j1 == j2){
                    int candies = grid[i][j1] + pickMax(i+1,j1 + dj1, j2+dj2,grid,dp);
                    max = Math.max(max,candies);
                }else{
                    int candies = grid[i][j1] + grid[i][j2] + pickMax(i+1,j1 + dj1, j2+dj2,grid,dp);
                    max = Math.max(max,candies);
                }
            }
        }
        return dp[i][j1][j2] = max;
    }
}