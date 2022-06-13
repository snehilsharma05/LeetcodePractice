class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int cols = triangle.get(triangle.size()-1).size();
        int[][] dp = new int[rows][cols];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        
        return minPathSum(0,0,triangle,dp);
    }
    private int minPathSum(int m,int n,List<List<Integer>> triangle,int[][] dp){
        if(m == triangle.size()){
            return 0;
        }
        
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        
        int bottom = triangle.get(m).get(n) + minPathSum(m+1,n,triangle,dp);
        int diag = triangle.get(m).get(n) + minPathSum(m+1,n+1,triangle,dp);
        return dp[m][n] = Math.min(bottom,diag);
    }
}