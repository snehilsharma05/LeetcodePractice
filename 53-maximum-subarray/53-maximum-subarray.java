class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, maxSum = Integer.MIN_VALUE, n = nums.length;
        for(int i=0;i<n;i++){
            sum += nums[i];
            if(nums[i] > sum){
                sum = nums[i];
            }
            
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}