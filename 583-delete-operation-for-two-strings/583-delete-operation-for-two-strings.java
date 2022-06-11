class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        
        return m + n - 2 * LCS(word1,word2,m-1,n-1,dp);
    }
    private int LCS(String word1,String word2,int m,int n,int[][] dp){
        if(m == -1 || n == -1){
            return 0;
        }
        
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        
        if(word1.charAt(m) == word2.charAt(n)){
            return dp[m][n] = 1 + LCS(word1,word2,m-1,n-1,dp);
        }else{
            return dp[m][n] = Math.max(LCS(word1,word2,m-1,n,dp), LCS(word1,word2,m,n-1,dp));
        }
    }
}