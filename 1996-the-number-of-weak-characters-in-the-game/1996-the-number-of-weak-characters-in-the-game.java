class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties,(p1,p2)->{
            if(p1[0] != p2[0]){
                return p1[0] - p2[0];
            }else{
                return p2[1] - p1[1];
            }
        });
        
        int count = 0, n = properties.length;
        int max = properties[n-1][1];
        
        for(int i=n-2;i>=0;i--){
            if(properties[i][1] < max){
                count++;
            }
            
             max = Math.max(max,properties[i][1]);
        }
        return count;
    }
}