class Solution {
    private final static int[][] dirs = {{0,-1},{1,0},{0,1},{-1,0}};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] cache = new int[m][n];
        
        int max = 1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int len = dfs(i,j,matrix,m,n,cache);
                max = Math.max(max,len);
            }
        }
        return max;
    }
    
    private int dfs(int i,int j,int[][] matrix,int m,int n,int[][] cache){
        if(cache[i][j] != 0){ //minimum length will be at least one, every element is increasing in itself
            return cache[i][j];
        }
        
        int max = 1;
        for(int[] dir:dirs){
            int nbrX = i + dir[0],nbrY = j + dir[1];
            
            if(nbrX<0 || nbrY<0 || nbrX>=m || nbrY>=n || matrix[nbrX][nbrY] <= matrix[i][j]){
                continue;
            }
            
            int len = 1 + dfs(nbrX,nbrY,matrix,m,n,cache);
            max = Math.max(max,len);
        }
        
        return cache[i][j] = max;
    }

}