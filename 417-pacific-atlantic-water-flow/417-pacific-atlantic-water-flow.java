class Solution {
    private static int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        if(heights == null || heights.length==0){
            return ans;
        }
        
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        //dfs
        for(int j=0;j<n;j++){
            dfs(heights,0,j,Integer.MIN_VALUE,pacific);
            dfs(heights,m-1,j,Integer.MIN_VALUE,atlantic);
        }
        
        for(int i=0;i<m;i++){
            dfs(heights,i,0,Integer.MIN_VALUE,pacific);
            dfs(heights,i,n-1,Integer.MIN_VALUE,atlantic);
        }
        
        //compute result
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }
    private void dfs(int[][] heights,int row,int col,int prev,boolean[][] ocean){
        if(row<0 || col<0 || row>=heights.length || col>=heights[0].length || ocean[row][col]){
            return;
        }
        if(heights[row][col]<prev)return;
        ocean[row][col] = true;
        for(int[] d:dir){
            dfs(heights,row+d[0], col+d[1], heights[row][col],ocean);   
        }
    }
}