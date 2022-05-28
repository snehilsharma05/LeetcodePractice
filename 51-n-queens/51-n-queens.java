class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] row:board){
            Arrays.fill(row,'.');
        }
        
        solve(0,board,ans);
        return ans;
    }
    
    private void solve(int col,char[][] board,List<List<String>> ans){
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
            if(isSafe(row,col,board)){
                board[row][col] = 'Q';
                solve(col+1,board,ans);
                board[row][col] = '.';
            }
        }
        
    }
    
    private boolean isSafe(int row,int col,char[][] board){
        int dupRow = row,dupCol = col;
        
        //left top diagonal
        while(row>=0 && col>=0){
            if(board[row][col] == 'Q'){
                return false;
            }
            row--;
            col--;
        }
        
        row = dupRow;col = dupCol;
        //left side in row
        while(col>=0){
            if(board[row][col] == 'Q'){
                return false;
            }
            col--;
        }
        
        row = dupRow;col = dupCol;
        //left bottom diagonal
        while(row<board.length && col>=0){
            if(board[row][col] == 'Q'){
                return false;
            }
            row++;
            col--;
        }
        
        return true;
    }
}