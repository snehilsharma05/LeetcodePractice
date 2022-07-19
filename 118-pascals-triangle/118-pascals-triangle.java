class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> prev = null;
        for(int row=0;row<numRows;row++){
            List<Integer> currRow = new ArrayList<>();
            for(int col=0;col<=row;col++){
                if(col == 0 || col == row){
                    currRow.add(1);
                }else{
                    currRow.add(prev.get(col-1)+prev.get(col));
                }
            }
            ans.add(currRow);
            prev = currRow;   
        }
        
        return ans;
    }
}