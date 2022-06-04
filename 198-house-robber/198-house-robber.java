class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        int prev = nums[0],prev2 = 0;
        
        for(int index=1;index<n;index++){
            int pick = nums[index] + prev2;    
            int notPick = 0 + prev;
            int curr = Math.max(pick,notPick);
            
            prev2 = prev;
            prev = curr;
        }
        
        return prev;
        //return maxAmount(n-1,nums,dp);
    }
    
    private int maxAmount(int index,int[] nums,int[] dp){
        if(index == 0){
            return nums[0];
        }
        
        if(index < 0){
            return 0;
        }
        
        if(dp[index] != -1){
            return dp[index];
        }
        
        int pick = nums[index] + maxAmount(index-2,nums,dp);
        int notPick = 0 + maxAmount(index-1,nums,dp);
        
        return dp[index] = Math.max(pick,notPick);
    }
}