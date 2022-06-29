class Solution {
    private class Pair{
        int x,y;
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
        
        public String toString(){
            return x+"-"+y;
        }
    }
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        
        int totalOranges = 0;
        Queue<Pair> q = new LinkedList<>();
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j));
                }
                
                if(grid[i][j] != 0){
                    totalOranges++;
                }
            }
        }
        
        int minutes = 0;
        int orangesProcessed = 0;
        int[][] dirs = {{0,-1},{1,0},{0,1},{-1,0}};
        
        while(!q.isEmpty()){    
            int size = q.size();
            //System.out.println("Values in Queue-->"+q);
            while(size-- > 0){
                Pair curr = q.poll();
                if(visited[curr.x][curr.y]){
                    continue;
                }
                
                visited[curr.x][curr.y] = true;
                orangesProcessed++;
                
                for(int[] dir:dirs){
                    int nbrX = curr.x + dir[0];
                    int nbrY = curr.y + dir[1];
                    
                    if(isValid(grid,nbrX,nbrY,visited)){
                        grid[nbrX][nbrY] = 2;
                        q.add(new Pair(nbrX,nbrY));
                    }
                }
                
            }
           if(q.size() > 0){
               minutes++;
           } 
        }
        
        return orangesProcessed == totalOranges ? minutes : -1;
    }
    
    private boolean isValid(int[][] grid,int nbrX,int nbrY,boolean[][] visited){
        if(nbrX<0 || nbrY<0 || nbrX>=grid.length || nbrY>=grid[0].length || grid[nbrX][nbrY] != 1 || visited[nbrX][nbrY]){
            return false;
        }
        return true;
    }
}