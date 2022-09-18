class Solution {
    public int trap(int[] height) {
        int n = height.length,water = 0;
        int maxLeft = 0,maxRight = 0;
        int left = 0,right = n-1;
        while(left<=right){
            if(height[left]<=height[right]){
                if(height[left]<=maxLeft){
                    water+= (maxLeft - height[left]);
                }else{
                    maxLeft = height[left];
                }
                left++;
            }else{
                if(height[right]<=maxRight){
                water+= maxRight-height[right];
                }else{
                    maxRight = height[right];
                }
                right--;
            }
        }
        return water;
    }
}