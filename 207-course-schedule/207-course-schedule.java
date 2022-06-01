class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int v = 0;v<numCourses;v++){
            adj.add(new ArrayList<>());
        }
        
        int[] indegree = new int[numCourses];
        for(int[] pre:prerequisites){
            adj.get(pre[0]).add(pre[1]);
            indegree[pre[1]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int v=0;v<numCourses;v++){
            if(indegree[v] == 0){
                q.add(v);
            }
        }
        
        int coursesDone = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            coursesDone++;
            
            for(int nbr:adj.get(curr)){
                indegree[nbr]--;
                if(indegree[nbr] == 0){
                    q.add(nbr);
                }
            }
        }
        
        return coursesDone == numCourses;
    }
}