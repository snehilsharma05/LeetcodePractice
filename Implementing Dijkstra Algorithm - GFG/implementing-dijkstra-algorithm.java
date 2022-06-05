// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    private static class Pair{
        int node;
        int wsf;
        Pair(int node,int wsf){
            this.node = node;
            this.wsf = wsf;
        }
    }
    
    static int[] dijkstra(int N, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        int[] dist = new int[N];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dijkstra(S,adj,dist);
        return dist;
    }
    
    private static void dijkstra(int s,ArrayList<ArrayList<ArrayList<Integer>>> adj,int[] dist){
        boolean[] visited = new boolean[adj.size()];
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1,p2)->p1.wsf - p2.wsf);
        pq.add(new Pair(s,0));
        
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            
            if(visited[curr.node]){
                continue;
            }
            visited[curr.node] = true;
            dist[curr.node] = curr.wsf;
            
            for(ArrayList<Integer> nbr : adj.get(curr.node)){
                if(visited[nbr.get(0)] == false){
                    pq.add(new Pair(nbr.get(0),curr.wsf + nbr.get(1)));
                }
            }
        }
    }
}

