class Solution {
    public int maxProduct(int[] nums) {
        int pro = 1, n = nums.length, maxPro = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            pro = 1;
            for(int j=i;j<n;j++){
                pro *= nums[j];
                maxPro = Math.max(maxPro, pro);
            }
        }
        return maxPro;
    }
}