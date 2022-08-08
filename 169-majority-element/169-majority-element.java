class Solution {
    public int majorityElement(int[] nums) {
        int ele = -1, count = 0;
        for(int i=0;i<nums.length;i++){
            if(count == 0){
                count = 1;
                ele = nums[i];
            }else if(nums[i] == ele){
                count++;
            }else{
                count--;
            }
        }
        return ele;
    }
}