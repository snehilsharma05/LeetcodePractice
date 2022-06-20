class Solution {
    public int arrangeCoins(int n) {
        long i = 1;
        int stairs = 0;
        long coins = 0;
        while(coins+i<=n){
            coins += i;
            i++;
            stairs++;
        }
        return stairs;
    }
}