class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sssf = new ArrayList<>();
        
        storeSubsets(0,sssf,nums,ans);
        return ans;
    }
    
    private void storeSubsets(int index,List<Integer> sssf, int[] nums,List<List<Integer>> ans){
        if(index == nums.length){
            ans.add(new ArrayList<>(sssf));
            return;
        }
        
        //pick
        sssf.add(nums[index]);
        storeSubsets(index+1,sssf,nums,ans);
        sssf.remove(sssf.size()-1);
        
        //not pick
        storeSubsets(index+1,sssf,nums,ans);
    }
}