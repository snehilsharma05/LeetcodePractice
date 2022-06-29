class Solution {
    //though, sort basis on height, count value will help us figure out if we can place this person at curr index or not
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        
        int[][] ans = new int[n][2];
        for(int[] person:ans){
            Arrays.fill(person,-1);
        }
        
        Arrays.sort(people,(p1,p2)->p1[0] - p2[0]);
        
        for(int i=0;i<n;i++){
            int count = people[i][1];
            
            for(int j=0;j<n;j++){
                if(ans[j][0] == -1 && count == 0){ //this 'ith' person can be placed here, position is empty also count = 0
                    
                    ans[j][0] = people[i][0];
                    ans[j][1] = people[i][1];
                    break;
                }else if(ans[j][0] == -1 || ans[j][0]>=people[i][0]){ //position empty but count !=0 OR jth person height is greater
                    count--;   
                }
            }
        }
        return ans;
    }
}