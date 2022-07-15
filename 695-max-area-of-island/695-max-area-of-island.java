class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    maxArea = Math.max(maxArea,computeArea(i,j,grid,visited));
                }
            }
        }
        return maxArea;
    }
    
    private int computeArea(int i,int j,int[][] grid,boolean[][] visited){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == 0 || visited[i][j]){
            return 0;
        }
        
        visited[i][j] = true;
        return 1 + computeArea(i-1,j,grid,visited) + computeArea(i,j+1,grid,visited) + computeArea(i+1,j,grid,visited) +
                    computeArea(i,j-1,grid,visited);
    }
}