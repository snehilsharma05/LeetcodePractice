// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V + 1; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int N, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] visited = new boolean[N];
        for(int v=0;v<N;v++){
            if(!visited[v]){
                boolean[] currDfsVisited = new boolean[N];
                if(dfs(v,adj,visited,currDfsVisited)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(int node,ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] currDfsVisited){
        visited[node] = true;
        currDfsVisited[node] = true;
        
        for(int nbr:adj.get(node)){
            if(!visited[nbr]){
                if(dfs(nbr,adj,visited,currDfsVisited)){
                    return true;
                }
            }else if(currDfsVisited[nbr]){
                return true;
            }
        }
        currDfsVisited[node] = false;
        return false;
    }
}