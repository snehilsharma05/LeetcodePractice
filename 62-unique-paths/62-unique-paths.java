class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        
        return countPaths(m-1,n-1,dp);
    }
    
    private int countPaths(int m,int n,int[][] dp){
        if(m == 0 && n == 0){
            return 1;
        }
        if(m < 0 || n < 0){
            return 0;
        }
        
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        return dp[m][n] = countPaths(m-1,n,dp) + countPaths(m,n-1,dp);
    }
    

}