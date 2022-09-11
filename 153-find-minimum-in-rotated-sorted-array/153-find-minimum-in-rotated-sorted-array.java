class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        for(int num:nums){
            min = Math.min(min, num);
        }
        return min;
    }
}