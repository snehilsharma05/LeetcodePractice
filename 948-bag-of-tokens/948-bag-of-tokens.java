class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        //1. sort the tokens
        Arrays.sort(tokens);
        
        //2. buy at the cheapest and sell at the expensive
        int start = 0, end = tokens.length-1;
        int score = 0, ans = 0;
        
        while(start <= end){
            if(power >= tokens[start]){
                power -= tokens[start];
                start++;
                score++;
                ans = Math.max(ans, score);
            }else if(score > 0){ //we'll try to sell score so that we can get maximum power
                power += tokens[end];
                end--;
                score--;
            }else{
                break;
            }
        }
        return ans;
    }
}