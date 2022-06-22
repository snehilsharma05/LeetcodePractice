class Solution {
    public int countNegatives(int[][] grid) {
        int neg = 0;
        for(int[] row:grid){
            neg += countNegUsingBinSearch(row);
        }
        return neg;
    }
    
    private int countNegUsingBinSearch(int[] row){
        int n = row.length;
        int low = 0, high = n - 1, index = -1;
        while(low<=high){
            int mid = (low+high)>>1;
            if(row[mid]<0){
                index = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        if(index == -1){
            return 0;
        }else{
            return n - index;
        }
    }
}