class Solution {
    public int uniquePaths(int m, int n) {
        int N = m + n - 2;
        int r = m-1;
        
        double ans = 1;
        for(int i=1;i<=r;i++){
            ans = ans * (N-r+i)/i;
        }
        return (int)ans;
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