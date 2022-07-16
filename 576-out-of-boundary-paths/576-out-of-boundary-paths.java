class Solution {
    private static int mod = (int)1e9+7;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m][n][maxMove+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<=maxMove;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        
        return countPaths(m,n,maxMove,startRow,startColumn,dp);
    }
    
    private int countPaths(int m,int n,int maxMove,int startRow,int startColumn,int[][][] dp){
        if(maxMove < 0){
            return 0;
        }
        
        if(startRow<0 || startColumn<0 || startRow>=m || startColumn>=n){
            return 1;
        }
        
        if(dp[startRow][startColumn][maxMove] != -1){
            return dp[startRow][startColumn][maxMove];
        }
        
        long count = 0;
        count += countPaths(m,n,maxMove-1,startRow+1,startColumn,dp);
        count += countPaths(m,n,maxMove-1,startRow-1,startColumn,dp);
        count += countPaths(m,n,maxMove-1,startRow,startColumn+1,dp);
        count += countPaths(m,n,maxMove-1,startRow,startColumn-1,dp);
        return dp[startRow][startColumn][maxMove] = (int)(count%mod);
    }
}