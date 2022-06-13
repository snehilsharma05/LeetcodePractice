class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        
        return numDistinct(m-1,n-1,s,t,dp);
    }
    private int numDistinct(int m,int n,String s,String t,int[][] dp){
        if(n == -1){
            return 1;
        }
        
        if(m == -1){
            return 0;
        }
        
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        
        if(s.charAt(m) == t.charAt(n)){
            return dp[m][n] = numDistinct(m-1,n-1,s,t,dp) + numDistinct(m-1,n,s,t,dp);
        }else{
            return dp[m][n] = numDistinct(m-1,n,s,t,dp);
        }
    }
}