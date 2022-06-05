class Solution {
    private int count = 0;
    public int totalNQueens(int n) {
        count = 0;
        boolean[] row = new boolean[n];
        boolean[] leftTop = new boolean[2*n+1];
        boolean[] leftBottom = new boolean[2*n+1];
        
        backTrack(0,n,row,leftTop,leftBottom);
        return count;
    }
    private void backTrack(int currCol,int n, boolean[] row,boolean[] leftTop, boolean[] leftBottom){
        if(currCol == n){
            count++;
            return;
        }
        
        for(int r=0;r<n;r++){
            int index1 = r + currCol;
            int index2 = currCol - r + n;
            if(row[r] || leftTop[index1] || leftBottom[index2]){
                continue;
            }
            
            row[r] =  leftTop[index1] = leftBottom[index2] = true;
            backTrack(currCol+1,n,row,leftTop,leftBottom);
            row[r] =  leftTop[index1] = leftBottom[index2] = false;
        }
    }
}