class Solution {
    public int maximumDifference(int[] nums) {
        int diff = -1, minLeft = nums[0];
        for(int i=1;i<nums.length;i++){
            diff = Math.max(diff,nums[i] - minLeft);
            minLeft = Math.min(minLeft,nums[i]);
        }
        return diff == 0 ? -1 : diff;
    }
}