class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];   
        int start = 0,end = n-1;
        for(int index = n-1;index>=0;index--){
            if(Math.abs(nums[start])>Math.abs(nums[end])){
                ans[index] = nums[start] * nums[start];
                start++;
            }else{
                ans[index] = nums[end] * nums[end];
                end--;
            }
        }
        return ans;
    }
}