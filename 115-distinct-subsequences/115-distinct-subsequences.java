class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[] prev = new int[n+1];
        prev[0] = 1;
     
        for(int i=1;i<=m;i++){
            int[] curr = new int[n+1];
            curr[0] = 1;
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    curr[j] = prev[j-1] + prev[j];
                }else{
                    curr[j] = prev[j];
                }
            }
            prev = curr;
        }
        
        return prev[n];
        //return numDistinct(m,n,s,t,dp);
    }
    private int numDistinct(int m,int n,String s,String t,int[][] dp){
        if(n == 0){
            return 1;
        }
        
        if(m == 0){
            return 0;
        }
        
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        
        if(s.charAt(m-1) == t.charAt(n-1)){
            return dp[m][n] = numDistinct(m-1,n-1,s,t,dp) + numDistinct(m-1,n,s,t,dp);
        }else{
            return dp[m][n] = numDistinct(m-1,n,s,t,dp);
        }
    }
}