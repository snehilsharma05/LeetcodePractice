class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[0] = 1; //"" string is valid, anyone can join at the back of ""
        
        if(s.charAt(0) !='0'){
            dp[1] = 1;
        }
        
        for(int i=2;i<dp.length;i++){
            int firstCut = Integer.parseInt(s.substring(i-1,i)); //1 length cut
            int secondCut = Integer.parseInt(s.substring(i-2,i)); //2 length cut
            
            if(firstCut > 0){ //mns from [1..9] valid char range, this char will be appended to the front string
                dp[i] = dp[i-1];
            }
            
            if(secondCut>=10 && secondCut<=26){ //second cut is of length 2, and valid chars are from 10 to 26
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }
}