class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return computeMaxSum(0,k,arr,dp);
    }
    private int computeMaxSum(int index,int k,int[] arr,int[] dp){
        if(index == arr.length){
            return 0;
        }
        
        if(dp[index]!=-1){
            return dp[index];
        }
        
        int maxSum = Integer.MIN_VALUE;
        int maxInSubArray = Integer.MIN_VALUE;
        int lenOfSubArray = 0;
        
        for(int part=index;part<Math.min(index+k,arr.length);part++){
            lenOfSubArray++;
            maxInSubArray = Math.max(maxInSubArray, arr[part]);
            int currSum = lenOfSubArray * maxInSubArray + computeMaxSum(part+1,k,arr,dp);
            maxSum = Math.max(maxSum,currSum);
        }
        
        return dp[index] = maxSum;
    }
}