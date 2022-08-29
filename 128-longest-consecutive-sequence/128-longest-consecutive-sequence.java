class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length, maxLength = 0;
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        
        for(int num:nums){
            if(!set.contains(num-1)){
                int data = num;
                while(set.contains(data)){
                    data++;
                }
                maxLength = Math.max(maxLength, data - num);
            }
        }
        return maxLength;
    }
}