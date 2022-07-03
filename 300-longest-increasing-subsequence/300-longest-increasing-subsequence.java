class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> dp = new ArrayList<>();
        dp.add(nums[0]);
        
        for(int i=1;i<n;i++){
            if(dp.get(dp.size()-1) < nums[i]){
                dp.add(nums[i]);
            }else{
                int index = Collections.binarySearch(dp,nums[i]);
                if(index<0){
                    index = -index - 1;
                }
                dp.set(index,nums[i]);
            }
        }
        return dp.size();
    }
}