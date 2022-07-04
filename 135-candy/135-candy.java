class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] L2R = new int[n];
        int[] R2L = new int[n];
        Arrays.fill(L2R,1);
        Arrays.fill(R2L,1);
        
        for(int i=1;i<n;i++){
            if(ratings[i-1]<ratings[i]){
                L2R[i] = 1 + L2R[i-1];
            }
        }
        
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                R2L[i] = 1 + R2L[i+1];
            }
        }
        
        int ans = 0;
        for(int i=0;i<n;i++){
            ans += Math.max(L2R[i],R2L[i]);
        }
        return ans;
    }
}