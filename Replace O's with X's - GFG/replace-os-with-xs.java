//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    private static final int[][] dirs = {{0,-1},{1,0},{0,1},{-1,0}};
    static char[][] fill(int n, int m, char mat[][])
    {
        // code here
        boolean[][] visited = new boolean[n][m];
        for(int col=0;col<m;col++){
            if(mat[0][col] == 'O' && !visited[0][col]){
                dfs(0,col, mat, visited);
            }
        }
        for(int row=1;row<n;row++){
         if(mat[row][m-1] == 'O' && !visited[row][m-1]){
                dfs(row, m-1, mat, visited);     
            }
        }
        
        for(int col=m-2;col>=0;col--){
            if(mat[n-1][col] == 'O' && !visited[n-1][col]){
                dfs(n-1, col, mat, visited);
            }
        }
        
        for(int row = n-2;row>0;row--){
            if(mat[row][0] == 'O' && !visited[row][0]){
                dfs(row, 0, mat, visited);
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 'O' && !visited[i][j]){
                    mat[i][j] = 'X';
                }
            }
        }
        return mat;
    }
    
    private static void dfs(int i, int j, char[][] mat, boolean[][] visited){
        if(i< 0 || j<0 || i>=mat.length || j>=mat[0].length || mat[i][j] == 'X' || visited[i][j]){
            return;
        }
        
        visited[i][j] = true;
        for(int[] d:dirs){
            int nbrX = i + d[0];
            int nbrY = j + d[1];
            dfs(nbrX, nbrY, mat, visited);
        }
    }
        
    
}