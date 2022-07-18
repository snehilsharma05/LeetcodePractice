class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=1;j<n;j++){
                matrix[i][j] += matrix[i][j-1]; //compute prefix sum in every row
            }
        }
        
        int count = 0;
        for(int col1=0;col1<n;col1++){
            for(int col2 = col1;col2<n;col2++){ //bound the matrix between two columns
                
                Map<Integer,Integer> map = new HashMap<>(); //subarray sum equals K problem
                map.put(0,1); //0 sum 1 baar aa chuka
                
                int sum = 0;
                for(int row=0;row<m;row++){ //in every row, delete the previous sums which is out of bounds
                    sum += matrix[row][col2] - (col1>0 ? matrix[row][col1-1] : 0);
                    count += map.getOrDefault(sum-target,0); //try to get sum-target
                    map.put(sum,map.getOrDefault(sum,0)+1); //increment count of this sum
                }
            }
        }
        return count;
    }
}