class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(i,j,grid,visited);
                    islands++;
                }
            }
        }
        return islands;
    }
    
    private void dfs(int i,int j,char[][] grid,boolean[][] visited){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || visited[i][j] || grid[i][j] == '0'){
            return;
        }
        visited[i][j] = true;
        dfs(i+1,j,grid,visited);
        dfs(i-1,j,grid,visited);
        dfs(i,j+1,grid,visited);
        dfs(i,j-1,grid,visited);
    }
}