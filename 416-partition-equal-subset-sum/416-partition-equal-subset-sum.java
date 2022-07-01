class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num:nums){
            sum += num;
        }
        
        if(sum % 2 != 0){
            return false;
        }else{
            int n = nums.length;
             int[] prev = new int[sum/2+1];
            // for(int[] row:dp){
            //     Arrays.fill(row,-1);
            // }
            
            
                prev[0] = 1;
            
            
            for(int target=1;target<=sum/2;target++){
                prev[target] = nums[0] == target ? 1:0;
            }
            
            for(int index=1;index<n;index++){
                int[] curr = new int[sum/2+1];
                for(int target=1;target<=sum/2;target++){
                    int notTake = prev[target];
                    int take = 0;
                    if(nums[index]<=target){
                        take = prev[target-nums[index]];
                    }
                    if(take == 1 || notTake == 1){
                        curr[target] = 1;
                    }else{
                        curr[target] = 0;
                    }
                }
                prev = curr;
            }
            return prev[sum/2] == 1;
            //return subsetSum(n-1,sum/2,nums,dp) == 1;
        }
    }
    private int subsetSum(int index,int target,int[] nums,int[][] dp){
        if(target == 0){
            return 1;
        }
        
        if(index == 0){
            return nums[index] == target ? 1: 0;
        }
        
        if(dp[index][target] != -1){
            return dp[index][target];
        }
        
        int notTake = subsetSum(index-1,target,nums,dp);
        int take = 0;
        if(nums[index]<=target){
            take = subsetSum(index-1,target - nums[index],nums,dp);
        }
        
        if(take == 1 || notTake == 1){
            dp[index][target] = 1;
        }else{
            dp[index][target] = 0;
        }
        
        return dp[index][target];
    }
}