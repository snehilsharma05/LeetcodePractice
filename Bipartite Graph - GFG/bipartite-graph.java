// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}// } Driver Code Ends


class Solution
{
    private class Pair{
        int node;
        int level;
        Pair(int node,int level){
            this.node = node;
            this.level = level;
        }
    }
    public boolean isBipartite(int N, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int[] level = new int[N];
        Arrays.fill(level,-1);
        
        for(int v=0;v<N;v++){
            if(level[v] == -1){
                if(!bfs(v,adj,level)){
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean bfs(int node,ArrayList<ArrayList<Integer>>adj,int[] level){
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(node,0));
        while(!q.isEmpty()){
            Pair curr = q.poll();
            if(level[curr.node] != -1){
                if(level[curr.node] != curr.level){
                    return false;
                }
            }else{
                level[curr.node] = curr.level;
            }
            
            for(int nbr:adj.get(curr.node)){
                if(level[nbr] == -1){
                    q.add(new Pair(nbr,curr.level+1));
                }
            }
        }
        return true;
    }
}