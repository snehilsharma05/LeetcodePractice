class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int maxLength = 1;
        
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i] && dp[i]<dp[j]+1){
                    dp[i] = dp[j] + 1;
                }
            }
            maxLength = Math.max(maxLength,dp[i]);
        }
        return maxLength;
    }
}