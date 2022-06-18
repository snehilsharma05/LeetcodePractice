class Solution {
    public int mySqrt(int x) {
        int low = 0, high = x;
        int ans = -1;
        while(low<=high){
            long mid = (low+high)>>1;
            
            if(mid*mid == x){ 
                return (int)mid;
            }else if(mid*mid > x){
                
                high = (int)(mid-1);
            }else{
                
                ans = (int)mid;
                low = (int)(mid+1);
            }
        }
        return ans;
    }
}