class Solution {
    public int minOperations(int[] nums, int x) {
        int target = 0;
        for(int num: nums){
            target += num;
        }
        
        target = target - x;
        int n = nums.length;
        
        if(target == 0){
            return n;
        }
        
        int res = Integer.MIN_VALUE;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        
        for(int i=0;i<n;i++){
            sum += nums[i];
            
            if(map.containsKey(sum - target)){
                res = Math.max(res, i - map.get(sum-target));
            }
            
            map.put(sum,i);
        }
        return res == Integer.MIN_VALUE ? -1 : n - res;
    }
}