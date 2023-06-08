//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private static final int[][] dirs = {{0,-1},{1,0},{0,1},{-1,0}};
    int numberOfEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length, count = 0;
        boolean[][] visited = new boolean[m][n];
        for(int col=0;col<n;col++){
            if(grid[0][col] == 1 && !visited[0][col]){
                dfs(0, col, grid, visited);
            }
        }
        
        for(int row=1;row<m;row++){
            if(grid[row][n-1] == 1 && !visited[row][n-1]){
                dfs(row, n-1, grid, visited);
            }
        }
        
        for(int col=n-2;col>=0;col--){
            if(grid[m-1][col] == 1 && !visited[m-1][col]){
                dfs(m-1, col, grid, visited);
            }
        }
        
        for(int row=m-2;row>0;row--){
            if(grid[row][0] == 1 && !visited[row][0]){
                dfs(row, 0, grid, visited);
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    count++;
                }
            }
        }
        return count;
    }
    
    private void dfs(int i, int j, int[][] grid, boolean[][] visited){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] != 1 || visited[i][j]){
            return;
        }
        
        visited[i][j] = true;
        for(int[] d: dirs){
            int nbrX = i + d[0];
            int nbrY = j + d[1];
            dfs(nbrX, nbrY, grid, visited);
        }
    }
}