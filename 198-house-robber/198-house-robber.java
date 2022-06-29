class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        
        return collectAmount(n-1,nums,dp);
    }
    
    private int collectAmount(int index,int[] nums,int[] dp){
        if(index == 0){
            return nums[index];
        }
        if(index<0){
            return 0;
        }
        
        if(dp[index] != -1){
            return dp[index];
        }
        
        int notPick = collectAmount(index-1,nums,dp);
        int pick = nums[index] + collectAmount(index-2,nums,dp);
        return dp[index] = Math.max(pick,notPick);
        
    }
}