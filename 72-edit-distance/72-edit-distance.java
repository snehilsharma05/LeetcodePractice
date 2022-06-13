class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];
        
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i == 0){
                    dp[i][j] = j;
                }else if(j == 0){
                    dp[i][j] = i;
                }else if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
                }
            }
        }
        return dp[m][n];
        
        //return minDistance(m,n,word1,word2,dp);
    }
    private int minDistance(int m,int n,String word1,String word2,int[][] dp){
        if(m == 0){
            return n;
        }else if(n == 0){
            return m;
        }
        
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        
        if(word1.charAt(m-1) == word2.charAt(n-1)){
            return dp[m][n] = minDistance(m-1,n-1,word1,word2,dp);
        }else{
            return dp[m][n] = 1 + Math.min(minDistance(m-1,n,word1,word2,dp),
                                  Math.min(minDistance(m,n-1,word1,word2,dp),minDistance(m-1,n-1,word1,word2,dp)));
        }
    }
}