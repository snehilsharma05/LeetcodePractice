class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        int[] freq = new int[n+1];
        
        for(int[]row:matrix){
            Arrays.fill(freq,0);
            for(int val:row){
                freq[val]++;
                if(freq[val]>1){
                    return false;
                }
            }
        }
        
        for(int j=0;j<n;j++){
            Arrays.fill(freq,0);
            for(int i=0;i<n;i++){
                freq[matrix[i][j]]++;
                if(freq[matrix[i][j]]>1){
                    return false;
                }
            }
        }
        return true;
    }
}