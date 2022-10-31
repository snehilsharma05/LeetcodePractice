class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j= 0;j<n;j++){
                if(i+1<m && j+1<n && matrix[i+1][j+1] != matrix[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}