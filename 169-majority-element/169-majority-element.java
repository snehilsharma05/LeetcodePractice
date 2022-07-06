class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int majority = -1;
        int freq = 0;
        for(int i=0;i<n;i++){
            if(freq == 0){
                majority = nums[i];
                freq++;
            }else if(nums[i] == majority){
                freq++;
            }else{
                freq--;
            }
        }
        return majority;
    }
}