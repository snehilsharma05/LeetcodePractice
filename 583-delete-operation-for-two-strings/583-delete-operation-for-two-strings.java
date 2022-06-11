class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[] prev = new int[n+1];
        
        for(int i=1;i<=m;i++){
            int[] curr = new int[n+1];
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    curr[j] = 1 + prev[j-1];
                }else{
                    curr[j] = Math.max(curr[j-1],prev[j]);
                }
            }
            prev = curr;
        }
        
        return m + n - 2 * prev[n];
    }
    private int LCS(String word1,String word2,int m,int n,int[][] dp){
        if(m == 0 || n == 0){
            return 0;
        }
        
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        
        if(word1.charAt(m-1) == word2.charAt(n-1)){
            return dp[m][n] = 1 + LCS(word1,word2,m-1,n-1,dp);
        }else{
            return dp[m][n] = Math.max(LCS(word1,word2,m-1,n,dp), LCS(word1,word2,m,n-1,dp));
        }
    }
}