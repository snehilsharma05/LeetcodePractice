class Solution {
    public int countNegatives(int[][] grid) {
        int neg = 0;
        for(int[] row:grid){
            for(int num:row){
                if(num < 0){
                    neg++;
                }
            }
        }
        return neg;
    }
}