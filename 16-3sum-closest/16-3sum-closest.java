class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans=nums[0] + nums[1] + nums[nums.length-1];
        for(int i=0;i<nums.length-2;i++)
        {
            int start = i+1,end = nums.length-1;
            
            while(start<end)
            {
                int currSum = nums[i] + nums[start] + nums[end];
                if(currSum== target)
                {
                    return currSum;
                }
                else if(currSum<target)
                {
                    start++;
                }
                else if(currSum>target)
                {
                    end--;
                }
             if(Math.abs(currSum-target) < Math.abs(ans-target))   
                 ans = currSum;
            }
        }
        return ans;
    }
}