class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] row:board){
            Arrays.fill(row,'.');
        }
        boolean[] leftRow = new boolean[n];
        boolean[] leftBottom = new boolean[2*n-1];
        boolean[] leftTop = new boolean[2*n-1];
        
        solve(0,board,ans,leftRow,leftBottom,leftTop);
        return ans;
    }
    
    private void solve(int col,char[][] board,List<List<String>> ans,boolean[] leftRow,boolean[] leftBottom,boolean[] leftTop){
        int n = board.length;
        if(col == board.length){
            List<String> boardCopy = new ArrayList<>();
            for(int i=0;i<board.length;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<board.length;j++){
                    sb.append(board[i][j]);
                }
                boardCopy.add(sb.toString());
            }
            
            ans.add(boardCopy);
            return;
        }
        
        for(int row=0;row<board.length;row++){
            if(leftRow[row] == false && leftBottom[row+col] == false && leftTop[n-1 + row - col] == false){
                board[row][col] = 'Q';
                leftRow[row] = true;
                leftBottom[row+col] = true;
                leftTop[n-1 + row - col] = true;
                
                
                solve(col+1,board,ans,leftRow,leftBottom,leftTop);
                
                board[row][col] = '.';
                leftRow[row] = false;
                leftBottom[row+col] = false;
                leftTop[n-1 + row - col] = false;
            }
        }
        
    }
    
    
}