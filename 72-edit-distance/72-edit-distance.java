class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return minDistance(m,n,word1,word2,dp);
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