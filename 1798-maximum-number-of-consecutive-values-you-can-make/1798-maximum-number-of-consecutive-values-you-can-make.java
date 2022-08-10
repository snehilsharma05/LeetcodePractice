class Solution {
    public int getMaximumConsecutive(int[] coins) {
        int sum = 1;
        Arrays.sort(coins); //sort the array, keep summing the values..sum means the next sum that we want to make
        for(int coin:coins){
            if(coin > sum){
                break;
            }
            sum += coin;
        }
        return sum;
        
    }
}