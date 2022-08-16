class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int negCount = 0;
        int absMinInMatrix = Integer.MAX_VALUE;
        for(int[] row:matrix){
            for(int data:row){
                if(data<0){
                    negCount++;
                }
                sum += Math.abs(data);
                absMinInMatrix = Math.min(absMinInMatrix,Math.abs(data));
            }
        }
        
        if(negCount % 2 == 0){
            return sum;
        }else{
            return sum - (2 * absMinInMatrix);
        }
    }
}