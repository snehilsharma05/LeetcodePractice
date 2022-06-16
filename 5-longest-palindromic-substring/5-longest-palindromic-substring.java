class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n+1][n+1];
        int posI = 0,posJ = 0;
        
        for(int g=0;g<n;g++){
            for(int i=0,j = g;j<n;i++,j++){
                if(g == 0){
                    dp[i][j] = true;
                }else if(g == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }else{
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                        dp[i][j] = true;
                    }
                }
                
                if(dp[i][j]){
                    posI = i;
                    posJ = j;
                }
            }
        }
        return s.substring(posI,posJ+1);
    }
}