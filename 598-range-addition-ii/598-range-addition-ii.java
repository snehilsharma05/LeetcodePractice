class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int max = ops.length;
        if(max == 0){
            return m*n;
        }
        
        int rowMin = Integer.MAX_VALUE,colMin = Integer.MAX_VALUE;
        for(int[] op:ops){
            rowMin = Math.min(rowMin,op[0]);
            colMin = Math.min(colMin,op[1]);
        }
        
        return rowMin * colMin;
    }
}