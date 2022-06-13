class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i == 0 && j == 0){
                    dp[i][j] = true;
                }else if(j == 0){
                    dp[i][j] = false;
                }else if(i == 0){
                    boolean flag = true;
                    for(int trav=1;trav<=j;trav++){
                        if(p.charAt(trav-1) != '*'){
                            flag =  false;
                            break;
                        }
                    }
                    dp[i][j] = flag;
                } else if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    if(p.charAt(j-1) == '*'){
                         dp[i][j] = dp[i-1][j] || dp[i][j-1];
                    }else{
                        dp[i][j] = false;
                    }
                }
            }
        }
        
        // int[][] dp = new int[m+1][n+1];
        // for(int[] row:dp){
        //     Arrays.fill(row,-1);
        // }
        return dp[m][n];
        //return isMatch(m,n,s,p,dp);
    }
    private boolean isMatch(int m,int n,String s,String p,int[][] dp){
        if(m == 0 && n == 0){
            return true;
        }else if(n == 0){
            return false;
        }else if(m == 0){
            for(int trav=1;trav<=n;trav++){
                if(p.charAt(trav-1) != '*'){
                    return false;
                }
            }
            return true;
        }
        if(dp[m][n] != -1){
            return dp[m][n] == 1;
        }
        
        if(s.charAt(m-1) == p.charAt(n-1) || p.charAt(n-1) == '?'){
            dp[m][n] = isMatch(m-1,n-1,s,p,dp)==true?1:0;
        }else{
            if(p.charAt(n-1) == '*'){
                 dp[m][n] = (isMatch(m-1,n,s,p,dp) || isMatch(m,n-1,s,p,dp)) == true? 1 : 0;
            }else{
                dp[m][n] = 0;
            }
        }
        return dp[m][n] == 1;
    }
}