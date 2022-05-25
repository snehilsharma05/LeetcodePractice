class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> psf = new ArrayList<>();
        
        Arrays.sort(candidates);
        combSum2(0,target,psf,candidates,ans);
        return ans;
    }
    private void combSum2(int index,int target,List<Integer> psf,int[] candidates,List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(psf));
        }
        
        for(int i=index;i<candidates.length;i++){
            if(i != index && candidates[i] == candidates[i-1]){
                continue;
            }else if(candidates[i]>target){
                break;
            }
            
            psf.add(candidates[i]);
            combSum2(i+1,target-candidates[i], psf, candidates, ans);
            psf.remove(psf.size()-1);
        }
    }
}