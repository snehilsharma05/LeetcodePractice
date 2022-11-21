class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        int steps = 0;
        int[][] dirs = {{0,-1},{1,0}, {0,1}, {-1,0}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {entrance[0], entrance[1]});
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size-- > 0){
                int[] currCell = q.poll();
                if(visited[currCell[0]][currCell[1]]){
                    continue;
                }

                visited[currCell[0]][currCell[1]] = true;
                //System.out.println(currCell[0]+ ", "+ currCell[1]);
                if((currCell[0] == 0 || currCell[0] == m-1 || currCell[1] == 0 || currCell[1] == n-1) && 
                    !(currCell[0] == entrance[0] && currCell[1] == entrance[1])){
                    return steps;
                }

                for(int[] dir: dirs){
                    int nbrX = currCell[0] + dir[0];
                    int nbrY = currCell[1] + dir[1];

                    if(nbrX>=0 && nbrX<m && nbrY>=0 && nbrY<n && !visited[nbrX][nbrY] && maze[nbrX][nbrY] == '.'){
                        //System.out.println ("Inside condition");
                        q.add(new int[]{nbrX, nbrY});
                    }
                }
            }
            
            steps++;
        }
        return -1; //never reached at the boundary
    }
}