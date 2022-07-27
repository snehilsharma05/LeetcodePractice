class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        
        int rowMin = m,colMin = n;
        for(int[] op:ops){
            rowMin = Math.min(rowMin,op[0]);
            colMin = Math.min(colMin,op[1]);
        }
        
        return rowMin * colMin;
    }
}