class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        
        int maxIndex = 0,maxLength = 1;
        int[] hash = new int[n];
        for(int i=0;i<n;i++){
            hash[i] = i;
            for(int j=0;j<i;j++){
                if(nums[i] % nums[j] == 0 && dp[i]<dp[j]+1){
                    dp[i] = dp[j]+1;   
                    hash[i] = j;
                }
            }
            
            if(dp[i]>maxLength){
                maxLength = dp[i];
                maxIndex = i;    
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        while(hash[maxIndex] != maxIndex){
            ans.add(nums[maxIndex]);
            maxIndex = hash[maxIndex];
        }
        ans.add(nums[maxIndex]);
        Collections.reverse(ans);
        return ans;
    }
}