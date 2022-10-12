class Solution {
    public int largestPerimeter(int[] nums) {
        //for a>=b>=c can form a triangle if a < b+c
        Arrays.sort(nums);
        for(int i = nums.length-1;i>=2;i--){
            if(nums[i]< nums[i-1] + nums[i-2]){
                return nums[i] + nums[i-1] + nums[i-2];
            }
        }
        return 0;
    }
}