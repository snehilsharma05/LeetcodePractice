class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permute(0,nums,ans);
        return ans;
    }
    private void permute(int index,int[] nums,List<List<Integer>> ans){
        if(index == nums.length){
            List<Integer> perm = new ArrayList<>();
            for(int num:nums){
                perm.add(num);
            }
            ans.add(perm);
            return;
        }
        
        for(int i=index;i<nums.length;i++){
            swap(nums,index,i);
            permute(index+1,nums,ans);
            swap(nums,index,i);
        }
    }
    
    private void swap(int[] nums,int i1,int i2){
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}