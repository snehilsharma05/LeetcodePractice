class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(w1,w2)->w1.length() - w2.length());
        
        int n = words.length;  
        
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int maxLength = 1;
        
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(isPossible(words[i],words[j]) && dp[i]<dp[j]+1){
                    dp[i] = dp[j] + 1;
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
    
    private boolean isPossible(String word1,String word2){
        if(word1.length() != word2.length()+1){
            return false;
        }
        
        int ptr1 = 0,ptr2 = 0;
        while(ptr1<word1.length()){
            if(ptr2<word2.length() && word1.charAt(ptr1) == word2.charAt(ptr2)){
                ptr1++;
                ptr2++;
            }else{
                ptr1++;
            }
        }
        return ptr1 == word1.length() && ptr2 == word2.length();
    }
}