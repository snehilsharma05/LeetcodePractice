class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num:nums){
            sum += num;
        }
        if(sum % 2 != 0){
            return false;
        }
        
        int n = nums.length;
        int[][] dp = new int[n+1][sum+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        
        return isPossible(n-1,sum/2,nums,dp);
    }
    private boolean isPossible(int index,int target,int[] nums,int[][] dp){
        if(target == 0){
            return true;
        }
        
        if(index == 0){
            return nums[index] == target;
        }
        
        if(dp[index][target] != -1){
            return dp[index][target] == 1;
        }
        
        
        boolean notTake = isPossible(index-1,target,nums,dp);
        boolean take = false;
        if(target>=nums[index]){
            take = isPossible(index-1,target - nums[index],nums,dp);
        }
        
        
        if(take || notTake){
             dp[index][target] = 1;
        }else{
             dp[index][target] = 0;
        }
        
        return  dp[index][target] == 1;
    }
}