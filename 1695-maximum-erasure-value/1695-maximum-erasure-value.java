class Solution {
    //subarray with unique elements and sum of those elements
    public int maximumUniqueSubarray(int[] nums) {
        int maxSum = 0;
        int n = nums.length, i = 0,j = 0;
        int sum = 0;
        
        Set<Integer> set = new HashSet<>();
        while(j < n){
            if(!set.contains(nums[j])){
                sum += nums[j];
                maxSum = Math.max(maxSum,sum);
                set.add(nums[j]);
                j++;
            }else{
                sum -= nums[i];
                set.remove(nums[i]);
                i++;
            }
        }
        return maxSum;
    }
}