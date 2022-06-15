class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        
        return lengthOfLIS(0,-1,nums,dp);
    }
    private int lengthOfLIS(int index,int prevIndexPicked, int[] nums,int[][] dp){
        if(index == nums.length){
            return 0;
        }
        
        if(dp[index][prevIndexPicked+1] != -1){
            return dp[index][prevIndexPicked+1];
        }
        
        int notTake = lengthOfLIS(index+1,prevIndexPicked,nums,dp);
        int take = 0;
        if(prevIndexPicked == -1 || nums[prevIndexPicked]<nums[index]){
            take = 1 + lengthOfLIS(index+1,index,nums,dp);
        }
        
        return dp[index][prevIndexPicked+1] = Math.max(notTake,take);
    }
}