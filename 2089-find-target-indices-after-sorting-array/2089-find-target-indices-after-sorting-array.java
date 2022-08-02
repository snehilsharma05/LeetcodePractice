class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> ans = new ArrayList<>();
        int count = 0,lessThan = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == target){
                count++;
            }else if(nums[i] < target){
                lessThan++;
            }
        }
        
        for(int i=lessThan;i<lessThan+count;i++){
            ans.add(i);
        }
        return ans;
    }
}