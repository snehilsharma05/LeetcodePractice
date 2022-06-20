class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int start = 1,index = 0;
        int miss = 0;
        while(miss<k){
            if(index<n && arr[index] == start){
                start++;
                index++;
            }else if((index < n && start<arr[index]) || index == n){
                start++;
                miss++;
            }
        }
        return start-1;
    }
}