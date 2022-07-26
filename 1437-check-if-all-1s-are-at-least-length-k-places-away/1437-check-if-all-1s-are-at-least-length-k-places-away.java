class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int i = 0, n = nums.length, prev = -1;
        while(i < n){
            if(nums[i] == 1){
                prev = i;
                break;
            }
            i++;
        }
        i++;
        int dist = 0;
        while(i<n){
            if(nums[i] == 0){
                dist++;
            }else{
                if(dist < k){
                    //System.out.println("dist"+dist+"index ="+i);
                    return false;
                }
                dist = 0;
                prev = i;
            }
            i++;
        }
        return true;
    }
}