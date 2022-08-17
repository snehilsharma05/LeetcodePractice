class Solution {
    private final static int dirs[][] = {{-1,0},{1,0},{0,-1},{0,1}}; //all 4 directions
    int[] DIR_X = {1, -1, 0, 0};
    int[] DIR_Y = {0, 0, 1, -1};
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && dfs(i,j,grid,grid[i][j],-1,-1,visited) == true){
                    //System.out.println("Cycle found for char: "+grid[i][j] + " and indices: "+i+", "+j);
                    return true;
                }
                
            
            }
        }
        return false;
    }

    
    private boolean dfs(int i,int j,char[][] grid,char initChar, int pRow,int pCol,boolean[][] visited){
        visited[i][j] = true;
         //valid indices
        boolean cycle = false;
            for(int[] dir:dirs){
                int nbrX = i + dir[0];
                int nbrY = j + dir[1];
                if(nbrX>=0 && nbrY>=0 && nbrX<grid.length && nbrY<grid[0].length && grid[nbrX][nbrY] == initChar && !(nbrX == pRow && nbrY == pCol)){
                    if(visited[nbrX][nbrY]){ //if nbr is not parent and is already visitex means we got a cycle
                        //System.out.println("Nbr cell already visited "+nbrX+", "+nbrY);
                        return true;
                    }
                    
                    cycle = dfs(nbrX,nbrY,grid,initChar,i,j,visited) || cycle; //if any further dfs call returned true means cycle is there
                    
                }
            }
        
        return cycle;
    }
    
    private void print(boolean[][] visited){
        for(int i=0;i<visited.length;i++){
            for(int j=0;j<visited[0].length;j++){
                System.out.print(visited[i][j]+" ");
            }
            System.out.println();
        }
    }
}