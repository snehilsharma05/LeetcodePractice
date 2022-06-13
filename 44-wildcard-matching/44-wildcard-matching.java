class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        int[][] dp = new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        
        return isMatch(m-1,n-1,s,p,dp);
    }
    private boolean isMatch(int m,int n,String s,String p,int[][] dp){
        if(m == -1 && n == -1){
            return true;
        }else if(n<0){
            return false;
        }else if(m<0){
            for(int i=0;i<=n;i++){
                if(p.charAt(i) != '*'){
                    return false;
                }
            }
            return true;
        }
        if(dp[m][n] != -1){
            return dp[m][n] == 1;
        }
        
        if(s.charAt(m) == p.charAt(n) || p.charAt(n) == '?'){
            dp[m][n] = isMatch(m-1,n-1,s,p,dp)==true?1:0;
        }else{
            if(p.charAt(n) == '*'){
                 dp[m][n] = (isMatch(m-1,n,s,p,dp) || isMatch(m,n-1,s,p,dp)) == true? 1 : 0;
            }else{
                dp[m][n] = 0;
            }
        }
        return dp[m][n] == 1;
    }
}