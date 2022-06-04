class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        return Math.max(maxAmount(0,n-2,nums),maxAmount(1,n-1,nums));
    }
    
    private int maxAmount(int start,int end,int[] nums){
        int prev = nums[start],prev2 = 0;
        for(int index=start+1;index<=end;index++){
            int take = nums[index] + prev2;
            int notTake = 0 + prev;
            int curr = Math.max(take,notTake);
            
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}