class Solution {
    public boolean isPowerOfThree(int n) {
        long start = 1;
        while(start<n){
            start *= 3;
        }
        return start == n;
    }
}