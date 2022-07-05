class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        
        int maxLen = 0;
        
        for(int i=0;i<n;i++){
            if(!set.contains(nums[i]-1)){ //starting point
                int data = nums[i];
                while(set.contains(data)){
                    data++;
                }
                //System.out.println("Data Updated-->"+data);
                maxLen = Math.max(maxLen,data - nums[i]);
            }
        }
        return maxLen;
    }
}