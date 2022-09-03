class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9);
        
        for(int digits=2;digits<=n;digits++){
            List<Integer> modified = new ArrayList<>();
            
            for(int num:nums){
                int rem = num % 10;
                
                if(rem + k < 10){
                    modified.add(num * 10 + rem + k);
                }
                
                if(k > 0 && rem - k >= 0){
                    modified.add(num * 10 + rem - k);
                }
            }
            nums = modified;
        }
        
        int[] ans = new int[nums.size()];
        for(int i=0;i<nums.size();i++){
            ans[i] = nums.get(i);
        }
        
        return ans;
    }
}