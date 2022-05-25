class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> psf = new ArrayList<>();
        
        storeComb(0,target,psf,candidates,ans);
        return ans;
    }
    private void storeComb(int index,int target,List<Integer> psf,int[] candidates,List<List<Integer>> ans){
        if(index == candidates.length){
            if(target == 0){
                ans.add(new ArrayList<>(psf));
            }
            return;
        }
        
        //pick and stay at same index
        if(candidates[index] <= target){
            psf.add(candidates[index]);
            storeComb(index,target - candidates[index], psf, candidates, ans);
            psf.remove(psf.size()-1);
        }
        
        //not pick
        storeComb(index+1,target, psf, candidates, ans);
    }
}