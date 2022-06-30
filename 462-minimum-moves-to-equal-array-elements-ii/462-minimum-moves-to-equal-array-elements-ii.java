class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int low = 0,high = nums.length-1;
        int moves = 0;
        
        while(low<=high){
            moves += nums[high] - nums[low];
            low++;
            high--;
        }
        return moves;
    }
}