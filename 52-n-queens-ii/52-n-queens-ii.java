class Solution {
    public int totalNQueens(int n) {
         List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] row:board){
            Arrays.fill(row,'.');
        }
        
        solve(0,board,ans);
        return ans.size();
    }
     private void solve(int col,char[][] board,List<List<String>> ans){
        if(col == board.length){
            List<String> copyBoard = new ArrayList<>();
            for(char[] row:board){
                String str = new String(row);
                copyBoard.add(str);
            }
            ans.add(copyBoard);
            return;
        }
        
        for(int row=0;row<board.length;row++){
            if(isPossible(board,row,col)){
                board[row][col] = 'Q';
                solve(col+1,board,ans);
                board[row][col] = '.';
            }
        }
    }
    private boolean isPossible(char[][] board,int row,int col){
        int rowDup = row,colDup = col;
        
        while(row>=0 && col>=0){
            if(board[row][col] == 'Q'){
                return false;
            }    
            row--;
            col--;
        }
        
        row = rowDup; col = colDup;
        while(row<board.length && col>=0){
            if(board[row][col] == 'Q'){
                return false;
            }
            row++;
            col--;
        }
        row = rowDup; col = colDup;
        while(col>=0){
            if(board[row][col] == 'Q'){
                return false;
            }
            col--;
        }
        return true;
    }
}